package cn.basion.beans.factory.config;

/**
 * @description: bean的定义
 * @author: wupeineng
 * @create: 2022-12-06 9:22
 */
public class BeanDefinition {
    private Class beanClass;

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
    public BeanDefinition(Class beanClass){
        this.beanClass = beanClass;
    }
}
