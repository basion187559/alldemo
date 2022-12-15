package cn.basion.beans.factory.support;

import cn.basion.beans.factory.config.BeanDefinition;

/**
 * @description:
 * @author: wupeineng
 * @create: 2022-12-09 8:55
 */
public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
    /**
     * 判断是否包含指定名称的BeanDefinition
     * @param beanName
     * @return
     */
    boolean containsBeanDefinition(String beanName);
}
