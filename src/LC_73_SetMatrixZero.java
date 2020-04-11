/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

import java.util.HashSet;
import java.util.Set;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/1/19
 */
public class LC_73_SetMatrixZero {

    public void setZeros(int[][] matrix){
        int R = matrix.length;
        int C = matrix[0].length;

        Set<Integer> rows = new HashSet<Integer>();
        Set<Integer> cols = new HashSet<Integer>();

        for(int i = 0;i < R;i++){
            for(int j = 0;j<C;j++){
                if(matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for(int i = 0;i < R;i++){
            for(int j = 0;j<C;j++){
                if(rows.contains(i) || cols.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }


    }

}