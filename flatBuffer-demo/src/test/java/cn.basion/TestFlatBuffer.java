package cn.basion;

import cn.basion.bean.Person;
import com.google.flatbuffers.FlatBufferBuilder;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * Copyright © DEEPEXI Technologies Co., Ltd. 2020-2022. All rights reserved.
 *
 * @author wupeineng
 * @Description:
 * @date 2022/12/15
 */
public class TestFlatBuffer {

    private static final String fileName ="/Users/basion/workspace/alldemo/flatBuffer-demo/src/test/resources/person.data";

    @Test
    public void testWrite() throws Exception{
        //创建person对象
        FlatBufferBuilder builder = new FlatBufferBuilder();
        int root = Person.createPerson(builder,builder.createString("basion"),30);
        builder.finish(root);
        //序列化person对象为字节码
        byte[] buffer = builder.sizedByteArray();
        //保存字节码到文件 也可以进行网络传输
        FileOutputStream out = new FileOutputStream(fileName);
        out.write(buffer);
        out.close();
    }

    @Test
    public void testRead() throws Exception{
        // [1] 从文件读取字节码，也可以是使用 Socket 传输得到的
        byte[] buf = new byte[1024];
        FileInputStream in = new FileInputStream(fileName);
        in.read(buf);
        in.close();

        //字节码反序列化为Person对象
        ByteBuffer buffer = ByteBuffer.wrap(buf);
        Person person = Person.getRootAsPerson(buffer);
        System.out.println("name:"+person.name()+",age:"+person.age());

    }
}
