package cn.basion;


import cn.basion.bean.UserDao;
import cn.basion.bean.UserService;
import cn.basion.beans.PropertyValue;
import cn.basion.beans.PropertyValues;
import cn.basion.core.io.DefaultResourceLoader;
import cn.basion.core.io.Resource;
import cn.basion.beans.factory.config.BeanDefinition;
import cn.basion.beans.factory.config.BeanReference;
import cn.basion.beans.factory.support.DefaultListableBeanFactory;
import cn.basion.beans.factory.xml.XmlBeanDefinitionReader;
import cn.hutool.core.io.IoUtil;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    @Test
    public void test_BeanFactory()
    {
        //初始化beanfactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //UserDao注册
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        //UserService 设置属性 uId,userDao
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId","1001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));

        //注册UserService bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService",beanDefinition);
        // 5. UserService 获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();

    }
    private DefaultResourceLoader resourceLoader;
    @Before
    public void init(){
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_classpath() throws IOException{
        Resource resource = resourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }
    @Test
    public void test_file() throws IOException{
        Resource resource = resourceLoader.getResource("src/test/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }
    @Test
    public void test_url() throws IOException{
        Resource resource = resourceLoader.getResource("https://github.com/fuzhengwei/small-spring/blob/main/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }
    @Test
    public void test_xml(){
        //1、初始化 beanfactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //2、读取配置文件和注册bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        //3、获取bean对象调用方法
        UserService userService = beanFactory.getBean("userService", UserService.class);
        String result =  userService.queryUserInfo();
        System.out.println(result);
    }
}
