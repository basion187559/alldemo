package cn.basion.beans.factory.support;

import cn.basion.beans.BeansException;
import cn.basion.beans.factory.config.BeanDefinition;
import java.lang.reflect.Constructor;

/**
 * @description:
 * @author: wupeineng
 * @create: 2022-12-11 14:21
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy{
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args) throws BeansException {
        Class cls = beanDefinition.getBeanClass();
        try {
            if(null != constructor){
                return cls.getDeclaredConstructor(constructor.getParameterTypes()).newInstance(args);
            }else{
                return cls.getDeclaredConstructor().newInstance();
            }
        }catch (Exception e){
            throw new BeansException("Failed to instantiate [" + cls.getName() + "]", e);
        }

    }
}
