/*
 * Copyright (c) 2018 maoyan.com
 * All rights reserved.
 *
 */
package NFA;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 18/7/8
 */
public class Common {


    public static void main(String[] args) {
        String regexp = "(a|aa)*b";
        String text   = "  aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaac";
        long start = System.currentTimeMillis();
        System.out.println(text.matches(regexp));

        regexp="(a*)*|b*";

        System.out.println(text.matches(regexp));
        System.out.println(System.currentTimeMillis()-start);
    }
}