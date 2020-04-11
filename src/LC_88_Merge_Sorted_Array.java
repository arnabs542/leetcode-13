/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/4/6
 */
public class LC_88_Merge_Sorted_Array {
    public void merge(int[] A, int m, int[] B, int n) {
        int i = m-1;
        int j = n-1;
        int k = m+n-1;
        while(i>=0 && j>=0){
            if(A[i] > B[j]){
                A[k--] = A[i--];
            }else{
                A[k--] = B[j--];
            }
        }

        while(j>=0){
            A[k--] = B[j--];
        }
    }
}