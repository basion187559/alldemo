package cn.basion.beans.factory;

import cn.basion.beans.BeansException;

/**
 * @description:
 * @author: wupeineng
 * @create: 2022-12-06 9:22
 */
public interface BeanFactory {

    Object getBean(String name) throws BeansException;
}
