package cn.basion.generic;

/**
 * Copyright © DEEPEXI Technologies Co., Ltd. 2020-2022. All rights reserved.
 *
 * @author wupeineng
 * @Description:
 * @date 2023/2/12
 */
public class GenericMethod {

    public static <T> int indexOf(T[] arrays, T element){
        for (int i = 0; i < arrays.length; i++) {
            if(arrays[i].equals(element)){
                return i;
            }
        }
        return -1;
    }

    public static <U,V> Pair<U,V> makePair(U u, V v){
        Pair<U,V> pair = new Pair<>(u,v);
        return pair;
    }

    public static <T extends Comparable> T max(T[] array){
        T max = array[0];
        for (int i = 0; i < array.length; i++) {
            if(array[i].compareTo(max) > 0 ){
                max = array[i];
            }
        }
        return max;

    }


}
