package sort;/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/2/7
 */
public class QuickSort {

    public static void sort(Comparable[] a){
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo,int hi){
        if(hi<=lo)
            return;

        int j = partition(a,lo,hi);

        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }

    private static int partition(Comparable[] a, int lo,int hi){
        int i = lo,j=hi+1;

        Comparable v = a[lo];

        while(i<j){
            while(CompareUtils.less(a[++i], v)){
                if(i == hi)
                    break;
            }

            while(CompareUtils.less(v, a[--j])){
                if(j == lo)
                    break;
            }

            CompareUtils.exch(a, i, j);
        }

        CompareUtils.exch(a, lo, j);

        return j;
    }






}