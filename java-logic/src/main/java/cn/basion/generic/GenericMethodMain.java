package cn.basion.generic;

/**
 * Copyright © DEEPEXI Technologies Co., Ltd. 2020-2022. All rights reserved.
 *
 * @author wupeineng
 * @Description:
 * @date 2023/2/12
 */
public class GenericMethodMain {
    public static void main(String[] args) {
        Integer[] arrays = new Integer[]{1,2,3,4,5};
        Integer num = 10;
        System.out.println(GenericMethod.indexOf(arrays,num));

        Person[] persons = new Person[2];
        Person basion = new Person(1L,"basion");
        Person basion1 = new Person(2L,"basion1");
        persons[0] = basion;
        persons[1] = basion1;

        GenericMethod.max(persons);
    }
}
