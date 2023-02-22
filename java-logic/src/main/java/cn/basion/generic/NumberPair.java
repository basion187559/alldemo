package cn.basion.generic;

/**
 * Copyright © DEEPEXI Technologies Co., Ltd. 2020-2022. All rights reserved.
 *
 * @author wupeineng
 * @Description:
 * @date 2023/2/12
 */
public class NumberPair<U extends  Number, V extends Number> extends Pair<U,V>{

    public NumberPair(U first, V second) {
        super(first, second);
    }

    public double sum(){
        return getFirst().doubleValue() + getSecond().doubleValue();
    }
}
