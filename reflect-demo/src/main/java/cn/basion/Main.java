package cn.basion;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @description:
 * @author: wupeineng
 * @create: 2022-12-11 11:31
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException {

        Class<?> cls = Class.forName("cn.basion.Man");
        while (cls.getSuperclass() != null){
            showFileds(cls);
            System.out.println("==========");
            cls = cls.getSuperclass();
        }

    }

    public static void showFileds(Class cls){
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields){
            System.out.println(field.getName());
        }
    }
}
