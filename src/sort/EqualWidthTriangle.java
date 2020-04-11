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
 * @created 20/4/2
 */
public class EqualWidthTriangle {


    public static void main(String[] args){
        printDengYangPicture(10);
    }


    public static void  printDengYangPicture(int n){
        for( int i =1;i<n;i++){
            printOneLine(i, n);
        }
    }

    public static void  printOneLine(int lineNum,int n){
        int startIndex = n -lineNum;
        for(int j = 0;j<startIndex-1;j++){
            System.out.print(" ");
        }
        for(int i=0;i<lineNum;i++){
            System.out.print(1+" ");
        }
        System.out.print("\r\n");
    }

}