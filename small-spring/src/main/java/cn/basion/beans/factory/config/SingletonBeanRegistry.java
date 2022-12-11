package cn.basion.beans.factory.config;

/**
 * @description:  单例注册表
 * @author: wupeineng
 * @create: 2022-12-08 8:57
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);
}
