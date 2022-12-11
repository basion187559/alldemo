package cn.basion.beans;

/**
 * @description:
 * @author: wupeineng
 * @create: 2022-12-06 9:20
 */
public class BeansException extends RuntimeException{

    public BeansException(String msg){
        super(msg);
    }

    public BeansException(String msg, Throwable cause){
        super(msg, cause);
    }
}
