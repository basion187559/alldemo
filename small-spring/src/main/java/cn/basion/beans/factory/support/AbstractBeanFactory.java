package cn.basion.beans.factory.support;

import cn.basion.beans.BeansException;
import cn.basion.beans.factory.BeanFactory;
import cn.basion.beans.factory.config.BeanDefinition;
import cn.basion.beans.factory.config.BeanPostProcessor;
import cn.basion.beans.factory.config.ConfigurableBeanFactory;

/**
 * @description:
 * @author: wupeineng
 * @create: 2022-12-08 8:56
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory {

    @Override
    public Object getBean(String name) throws BeansException {
      return doGetBean(name,null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name,args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requireType) throws BeansException {
        return (T)getBean(name);
    }


    protected <T> T doGetBean(String name, Object[] args){
        Object bean = getSingleton(name);
        if(bean != null){
            return (T)bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name,beanDefinition,args);

    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition,Object[] args) throws BeansException;

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {

    }
}
