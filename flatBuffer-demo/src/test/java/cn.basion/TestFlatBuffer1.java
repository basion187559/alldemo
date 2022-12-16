package cn.basion;

import cn.basion.bean.*;
import com.google.flatbuffers.FlatBufferBuilder;
import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * Copyright © DEEPEXI Technologies Co., Ltd. 2020-2022. All rights reserved.
 *
 * @author wupeineng
 * @Description:
 * @date 2022/12/15
 */
public class TestFlatBuffer1 {

    @Test
    public void test1(){
        FlatBufferBuilder builder = new FlatBufferBuilder(0);

        // Create some weapons for our Monster ('Sword' and 'Axe').
        int weaponOneName = builder.createString("Sword");
        short weaponOneDamage = 3;
        int weaponTwoName = builder.createString("Axe");
        short weaponTwoDamage = 5;

        // Use the `createWeapon()` helper function to create the weapons, since we set every field.
        int[] weaps = new int[2];
        weaps[0] = Weapon.createWeapon(builder, weaponOneName, weaponOneDamage);
        weaps[1] = Weapon.createWeapon(builder, weaponTwoName, weaponTwoDamage);

        // Serialize the FlatBuffer data.

        byte[] treasure = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int inv = Monster.createInventoryVector(builder, treasure);

        int weapons = Monster.createWeaponsVector(builder, weaps);
        int pos = Vec3.createVec3(builder, 1.0f, 2.0f, 3.0f);
        int name = builder.createString("Orc");
        Monster.startMonster(builder);
        Monster.addPos(builder, pos);
        Monster.addName(builder, name);
        Monster.addColor(builder, Color.Red);
        Monster.addHp(builder, (short)300);
        Monster.addInventory(builder, inv);
        Monster.addWeapons(builder, weapons);
        Monster.addEquippedType(builder, Equipment.Weapon);
        Monster.addEquipped(builder, weaps[1]);
        int orc = Monster.endMonster(builder);

        builder.finish(orc); // You could also call `Monster.finishMonsterBuffer(builder, orc);`.

        // We now have a FlatBuffer that can be stored on disk or sent over a network.

        // ...Code to store to disk or send over a network goes here...

        // Instead, we are going to access it right away, as if we just received it.

        ByteBuffer buf = builder.dataBuffer();

        // Get access to the root:
        Monster monster = Monster.getRootAsMonster(buf);

        // Note: We did not set the `mana` field explicitly, so we get back the default value.
        assert monster.mana() == (short)150;
        assert monster.hp() == (short)300;
        assert monster.name().equals("Orc");
        assert monster.color() == Color.Red;
        assert monster.pos().x() == 1.0f;
        assert monster.pos().y() == 2.0f;
        assert monster.pos().z() == 3.0f;

        // Get and test the `inventory` FlatBuffer `vector`.
        for (int i = 0; i < monster.inventoryLength(); i++) {
            assert monster.inventory(i) == (byte)i;
        }

        // Get and test the `weapons` FlatBuffer `vector` of `table`s.
        String[] expectedWeaponNames = {"Sword", "Axe"};
        int[] expectedWeaponDamages = {3, 5};
        for (int i = 0; i < monster.weaponsLength(); i++) {
            assert monster.weapons(i).name().equals(expectedWeaponNames[i]);
            assert monster.weapons(i).damage() == expectedWeaponDamages[i];
        }

        Weapon.Vector weaponsVector = monster.weaponsVector();
        for (int i = 0; i < weaponsVector.length(); i++) {
            assert weaponsVector.get(i).name().equals(expectedWeaponNames[i]);
            assert weaponsVector.get(i).damage() == expectedWeaponDamages[i];
        }

        // Get and test the `equipped` FlatBuffer `union`.
        assert monster.equippedType() == Equipment.Weapon;
        Weapon equipped = (Weapon)monster.equipped(new Weapon());
        assert equipped.name().equals("Axe");
        assert equipped.damage() == 5;

        System.out.println("The FlatBuffer was successfully created and verified!");


    }
}
