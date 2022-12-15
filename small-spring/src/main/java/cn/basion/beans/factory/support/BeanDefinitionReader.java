package cn.basion.beans.factory.support;

import cn.basion.beans.BeansException;
import cn.basion.io.Resource;
import cn.basion.io.ResourceLoader;

/**
 * @description:
 * @author: wupeineng
 * @create: 2022-12-11 16:55
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;
}
