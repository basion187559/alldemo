package cn.basion.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: wupeineng
 * @create: 2022-12-11 15:05
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue propertyValue){
        this.propertyValueList.add(propertyValue);
    }

    public PropertyValue[] getPropertyValues(){
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValues(String propertyName){
        for (PropertyValue propertyValue : propertyValueList){
            if(propertyValue.getName().equals(propertyName)){
                return propertyValue;
            }
        }
        return null;
    }

}
