package cn.basion.beans.core.io;

/**
 * @description:
 * @author: wupeineng
 * @create: 2022-12-11 16:42
 */
public interface ResourceLoader {
    /**
     * Pseudo URL prefix for loading from the class path: "classpath:"
     */
    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
