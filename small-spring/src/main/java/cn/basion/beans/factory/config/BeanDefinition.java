package cn.basion.beans.factory.config;

import cn.basion.beans.PropertyValue;
import cn.basion.beans.PropertyValues;
import lombok.Data;

/**
 * @description: bean的定义
 * @author: wupeineng
 * @create: 2022-12-06 9:22
 */
@Data
public class BeanDefinition {
    private Class beanClass;

    private PropertyValues propertyValues;

    public BeanDefinition(Class beanClass){
        this(beanClass,null);
    }
    public BeanDefinition(Class beanClass, PropertyValues propertyValues){
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }






}
