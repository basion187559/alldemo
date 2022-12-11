package cn.basion.beans;

import lombok.Data;

/**
 * @description: 属性值
 * @author: wupeineng
 * @create: 2022-12-11 15:03
 */
@Data
public class PropertyValue {
    private final String name;

    private final Object value;
    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }
}
