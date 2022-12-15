package cn.basion.beans.factory.config;

import cn.basion.beans.factory.HierarchicalBeanFactory;

/**
 * @description:
 * @author: wupeineng
 * @create: 2022-12-14 21:04
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory,SingletonBeanRegistry {
    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
