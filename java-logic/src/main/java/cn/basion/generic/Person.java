package cn.basion.generic;

/**
 * Copyright © DEEPEXI Technologies Co., Ltd. 2020-2022. All rights reserved.
 *
 * @author wupeineng
 * @Description:
 * @date 2023/2/12
 */
public class Person implements Comparable<Person> {

    private Long id;

    private String name;

    public Person(Long id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(Person o) {
        return (int) (this.id - o.id);
    }
}
