/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/2/12
 */
public class LC_54_Spiral_Matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List ans = new ArrayList<>();

        if(matrix.length == 0)
            return ans;

        int R = matrix.length, C = matrix[0].length;

        boolean[][] seen = new boolean[R][C];

        int[] dr = {0,1,0,-1};
        int[] dc = {1,0,-1,0};
        int r =0, c = 0, di=0;
        for(int i =0;i<R*C;i++){
            ans.add(matrix[r][c]);
            seen[r][c]=true;
            int cr = r + dr[di];
            int cc = c + dc[di];
            if(0 <= cr && cr < R && 0 <= cc && cc < C && !seen[cr][cc]){
                r = cr;
                c = cc;
            }else{
                di = (di+1)%4;
                r = r + dr[di];
                c = c + dc[di];
            }
        }

        return ans;

    }




    public List<Integer> spiralOrder_clockWise(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if(matrix.length == 0){
            return res;
        }

        int rowBegin = 0;
        int rowEnd = matrix.length-1;

        int colBegin = 0;
        int colEnd = matrix[0].length-1;

        while(rowBegin <= rowEnd && colBegin <= colEnd){
            // to right
            for(int j = colBegin; j<= colEnd;j++){
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;

            // to down

            for(int j = rowBegin;j<=rowEnd;j++){
                res.add(matrix[j][colEnd]);
            }

            colEnd --;

            for(int j = colEnd;j>=colBegin;j--){
                res.add(matrix[rowEnd][j]);
            }
            rowEnd --;

            for(int j = rowEnd;j>= rowBegin;j--){
                res.add(matrix[j][colBegin]);
            }
            colBegin++;
        }
        return res;
    }
































}