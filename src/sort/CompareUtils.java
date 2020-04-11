/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package sort;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/2/7
 */
public class CompareUtils {


    public static boolean less(Comparable a ,Comparable b){
        return a.compareTo(b)<0;
    }

    public static void exch(Comparable[]a ,int i,int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


}