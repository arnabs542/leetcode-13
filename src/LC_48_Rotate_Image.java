/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/2/10
 */
public class LC_48_Rotate_Image {

    /*
     * clockwise rotate
     * first reverse up to down, then swap the symmetry
     * 1 2 3     7 8 9     7 4 1
     * 4 5 6  => 4 5 6  => 8 5 2
     * 7 8 9     1 2 3     9 6 3
    */

    public void rotate(int[][] matrix) {

        int low = 0,high = matrix.length -1;

        // 以行为单位置换
        while(low<high){
            int[] temp = matrix[low];
            matrix[low] = matrix[high];
            matrix[high] = temp;
            high--;
            low++;
        }

        // 以 下滑对角线为对称轴，元素做左右置换

        for(int i = 0 ;i<matrix.length;i++){
            for(int j=i+1;j<matrix[i].length;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;

            }
        }


    }



    /*
     * anticlockwise rotate
     * first reverse left to right, then swap the symmetry
     * 1 2 3     3 2 1     3 6 9
     * 4 5 6  => 6 5 4  => 2 5 8
     * 7 8 9     9 8 7     1 4 7
    */
    public void anti_rotate(int[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int first=0, last=cols-1; first<last; first++,last--) {
            for(int i=0; i<matrix.length; i++) {
                int tmp = matrix[i][first];
                matrix[i][first] = matrix[i][last];
                matrix[i][last] = tmp;
            }
        }
        for(int i = 0; i < rows; i++){
            for(int j = i+1; j < cols; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }


}