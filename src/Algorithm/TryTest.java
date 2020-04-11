/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package Algorithm;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/3/27
 */
public class TryTest {

    public static void main(String[] args){
        System.out.println(value());
    }

    static int value(){
        try{
            return 0;
        }catch(Exception e) {

        } finally{
            return 1;
        }
    }

}