package cn.basion.beans.factory.xml;

import cn.basion.beans.BeansException;
import cn.basion.beans.core.io.Resource;
import cn.basion.beans.core.io.ResourceLoader;
import cn.basion.beans.factory.support.AbstractBeanDefinitionReader;
import cn.basion.beans.factory.support.BeanDefinitionRegistry;
import cn.hutool.core.util.XmlUtil;
import java.io.InputStream;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * @description:
 * @author: wupeineng
 * @create: 2022-12-11 17:04
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry){
        super(registry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader){
        super(registry,resourceLoader);
    }
    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {

    }

    @Override
    public void loadBeanDefinitions(Resource... resources) throws BeansException {

    }

    @Override
    public void loadBeanDefinitions(String location) throws BeansException {

    }

    protected void doLoadBeanDefinitions(InputStream inputStream) throws ClassNotFoundException{
        Document doc = XmlUtil.readXML(inputStream);
        Element root = doc.getDocumentElement();
        NodeList childNodes = root.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            //判断元素
            if(!(childNodes.item(i) instanceof Element){
                continue;
            }


        }
    }
}
