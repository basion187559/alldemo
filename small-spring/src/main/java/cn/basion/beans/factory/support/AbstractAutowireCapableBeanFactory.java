package cn.basion.beans.factory.support;

import cn.basion.beans.BeansException;
import cn.basion.beans.PropertyValue;
import cn.basion.beans.PropertyValues;
import cn.basion.beans.factory.config.AutowireCapableBeanFactory;
import cn.basion.beans.factory.config.BeanDefinition;
import cn.basion.beans.factory.config.BeanReference;
import cn.hutool.core.bean.BeanUtil;
import java.lang.reflect.Constructor;

/**
 * @description:
 * @author: wupeineng
 * @create: 2022-12-08 9:14
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory implements AutowireCapableBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition,Object[] args) throws BeansException {
        Object bean = null;
        try {
            bean = createBeanInstance(beanDefinition,beanName,args);
            // 给 Bean 填充属性
            applyPropertyValues(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleton(beanName,bean);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition,String beanName,Object[] args){
        Constructor constructor = null;
        Class beanClass = beanDefinition.getBeanClass();
        Constructor[] declaredConstructors = beanClass.getDeclaredConstructors();
        if(args != null){
            for (Constructor declaredConstructor : declaredConstructors){
                if(declaredConstructor.getParameterTypes().length == args.length){
                    constructor = declaredConstructor;
                    break;
                }
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition,beanName,constructor,args);
    }

    protected void applyPropertyValues(String beanName,Object bean, BeanDefinition beanDefinition){
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()){
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();
                if(value instanceof BeanReference){
                    //A依赖B,获取B的实例化
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                //属性填充
                BeanUtil.setFieldValue(bean,name,value);
            }
        }catch (Exception e){

        }
    }
    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
    @Override
    public Object applyBeanPostProcessorsBeforeInitialization(Object exitBean, String beanName) throws BeansException {
        return null;
    }
    @Override
    public Object applyBeanPostProcessorsAfterInitialization(Object exitBean, String beanName) throws BeansException {
        return null;
    }


}
