package cn.basion.context.support;

import cn.basion.beans.factory.support.DefaultListableBeanFactory;
import cn.basion.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * Convenient base class for {@link cn.basion.context.ApplicationContext}
 * implementations, drawing configuration from XML documents containing bean definitions.
 */
public abstract class AbstractXmlApplicationContext  extends AbstractRefreshableApplicationContext{
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory,this);
    }
}
