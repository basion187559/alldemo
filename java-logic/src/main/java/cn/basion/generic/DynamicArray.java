package cn.basion.generic;

import java.util.Arrays;

/**
 * Copyright © DEEPEXI Technologies Co., Ltd. 2020-2022. All rights reserved.
 *
 * @author wupeineng
 * @Description:
 * @date 2023/2/12
 */
public class DynamicArray<E> {
    public static final int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] elementData;
    public DynamicArray(){
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    private void ensureCapacity(int minCapacity){
        int oldCapacity = elementData.length;
        if(oldCapacity >= minCapacity){
            return;
        }
        int newCapacity = oldCapacity * 2;
        if(newCapacity < minCapacity){
            newCapacity = minCapacity;
        }
        elementData = Arrays.copyOf(elementData,newCapacity);
    }

    public void add(E e){
        ensureCapacity(size + 1);
        elementData[size++] = e;
    }
    public E get(int index){
        return (E)elementData[index];
    }


}
