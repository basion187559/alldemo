package cn.basion.context.support;

import cn.basion.beans.BeansException;
import cn.basion.beans.factory.ConfigurableListableBeanFactory;
import cn.basion.beans.factory.config.BeanFactoryPostProcessor;
import cn.basion.beans.factory.config.BeanPostProcessor;
import cn.basion.context.ConfigurableApplicationContext;
import cn.basion.io.DefaultResourceLoader;
import java.util.Map;
import javax.swing.table.TableCellEditor;

/**
 * @description:
 * @author: wupeineng
 * @create: 2022-12-15 9:19
 */
public abstract  class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    @Override
    public void refresh() throws BeansException {
        //1、创建 BeanFactory,并加载BeanDefinition
        refreshBeanFactory();
        //2、获取 BeanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        //3、在Bean实例化之前,执行BeanFactoryPostProcessor
        invokeBeanFactoryPostProcessors(beanFactory);
        //4、BeanPostProcessor 需要提前其他bean对象实例化之前执行注册操作
        registerBeanPostProcessors(beanFactory);
        //5、提前实例化单例Bean对象
        beanFactory.preInstantiateSingletons();

    }

    protected abstract void refreshBeanFactory() throws BeansException;

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory){
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for(BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()){
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory){
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for(BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()){
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    @Override
    public Object getBean(String name) throws BeansException {
        return getBeanFactory().getBean(name);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return getBeanFactory().getBean(name,args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requireType) throws BeansException {
        return getBeanFactory().getBean(name,requireType);
    }
}
