package cn.basion.beans.factory.support;

import cn.basion.beans.BeansException;
import cn.basion.beans.factory.config.BeanDefinition;

/**
 * @description:
 * @author: wupeineng
 * @create: 2022-12-08 9:14
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleton(beanName,bean);
        return bean;
    }
}
