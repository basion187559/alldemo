package cn.basion.beans.util;

/**
 * @description:
 * @author: wupeineng
 * @create: 2022-12-11 16:15
 */
public class ClassUtils {
    public static ClassLoader getDefaultClassLoader(){
        ClassLoader cl = null;
        try {
            cl = Thread.currentThread().getContextClassLoader();
        }catch (Throwable ex){

        }
        if(cl == null){
            cl = ClassUtils.class.getClassLoader();
        }
        return cl;
    }
}
