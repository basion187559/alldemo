package cn.basion.beans.factory.config;

import cn.basion.beans.BeansException;

/**
 * Extension of the {@link cn.basion.beans.factory.BeanFactory}
 * interface to be implemented by bean factories that are capable of
 * autowiring, provided that they want to expose this functionality for
 * existing bean instances.
 */
public interface AutowireCapableBeanFactory {
    /**
     * 执行 BeanPostProcessors接口实现类 postProcessBeforeInitialization
     * @param exitBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsBeforeInitialization(Object exitBean, String beanName) throws BeansException;

    /**
     * 执行BeanPostProcessors接口实现类的postProcessorsAfterInitialization方法
     * @param exitBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsAfterInitialization(Object exitBean, String beanName) throws BeansException;
}
