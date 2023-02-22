package cn.basion.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright © DEEPEXI Technologies Co., Ltd. 2020-2022. All rights reserved.
 *
 * @author wupeineng
 * @Description:
 * @date 2023/2/12
 */
public class Main {

    public static void main(String[] args) {
        List<String> stringArrayList = new ArrayList<String>();
        List<Integer> integerArrayList = new ArrayList<Integer>();

        Class classStringArrayList = stringArrayList.getClass();
        Class classIntegerArrayList = integerArrayList.getClass();

        System.out.println(classIntegerArrayList.equals(classStringArrayList));

        System.out.println(classIntegerArrayList);
        System.out.println(classStringArrayList);


    }
}
