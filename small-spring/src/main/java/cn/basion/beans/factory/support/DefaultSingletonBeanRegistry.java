package cn.basion.beans.factory.support;

import cn.basion.beans.factory.config.SingletonBeanRegistry;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: wupeineng
 * @create: 2022-12-08 8:58
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private final Map<String,Object> singletonObjects = new HashMap<>();


    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected void addSingleton(String name,Object singleObject){
        singletonObjects.put(name,singleObject);
    }
}
