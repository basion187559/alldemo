package cn.basion.generic;

/**
 * Copyright © DEEPEXI Technologies Co., Ltd. 2020-2022. All rights reserved.
 *
 * @author wupeineng
 * @Description:
 * @date 2023/2/12
 */
public class NumberPairMain {

    public static void main(String[] args) {
        NumberPair<Integer,Double> pair = new NumberPair<>(10, 12.34);
        double sum = pair.sum();
        System.out.println(sum);
    }
}
