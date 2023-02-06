package cn.basion.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * Copyright © DEEPEXI Technologies Co., Ltd. 2020-2022. All rights reserved.
 *
 * @author wupeineng
 * @Description:
 * @date 2023/2/1
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Enumeration<URL> resources = Main.class.getClassLoader().getResources("mybatis-config.xml");
        while (resources.hasMoreElements()){
            URL url = resources.nextElement();
            System.out.println(url);
        }
    }
}
