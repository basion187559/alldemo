package cn.basion;

import lombok.Data;

/**
 * @description:
 * @author: wupeineng
 * @create: 2022-12-11 11:31
 */
@Data
public class Person extends Base{


    private String name;


    @Override
    public String toString(){
        return "name:"+name;
    }

}
