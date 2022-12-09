package cn.basion.beans.factory.support;

import cn.basion.beans.BeansException;
import cn.basion.beans.factory.BeanFactory;
import cn.basion.beans.factory.config.BeanDefinition;

/**
 * @description:
 * @author: wupeineng
 * @create: 2022-12-08 8:56
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeansException {
        Object bean = getSingleton(name);
        if(bean != null){
            return bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name,beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;
}
