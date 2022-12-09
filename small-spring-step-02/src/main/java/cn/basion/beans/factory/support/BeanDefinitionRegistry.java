package cn.basion.beans.factory.support;

import cn.basion.beans.factory.config.BeanDefinition;

/**
 * @description:
 * @author: wupeineng
 * @create: 2022-12-09 8:55
 */
public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
