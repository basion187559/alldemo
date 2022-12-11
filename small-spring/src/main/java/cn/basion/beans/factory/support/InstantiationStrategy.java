package cn.basion.beans.factory.support;

import cn.basion.beans.BeansException;
import cn.basion.beans.factory.config.BeanDefinition;
import java.lang.reflect.Constructor;

/**
 * @description:
 * @author: wupeineng
 * @create: 2022-12-11 13:58
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor,Object[] args) throws BeansException;
}
