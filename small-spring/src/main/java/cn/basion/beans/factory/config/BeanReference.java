package cn.basion.beans.factory.config;

/**
 * @description:
 * @author: wupeineng
 * @create: 2022-12-11 15:28
 */

public class BeanReference {
    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
