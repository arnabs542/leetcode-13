/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

import java.util.HashSet;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/4/11
 */
public class LC_329_Longest_Increase_Path_Matrix {
    public static final int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

    /*
    O(mn) time O(mn) space. DFS + DP
     */
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0){
            return 0;
        }

        int m = matrix.length, n = matrix[0].length;
        int[][] cache = new int[m][n];
        int max = 1;

        for( int i = 0 ;i<m;i++){
            for(int j=0;j<n;j++){
                int len = dfs(matrix,i,j,m,n,cache);
                max = Math.max(max,len);
            }
        }

        return max;
    }



    public int dfs(int[][] matrix,int i, int j, int m,int n, int[][] cache){
        if(cache[i][j] != 0){
            return cache[i][j];
        }

        int max = 1;
        for(int[] dir:dirs){
            int x = i + dir[0],y=j+dir[1];

            if(x<0 || x>=m || y<0 | y>=n || matrix[x][y] <=matrix[i][j]){
                continue;
            }

            int len = 1 + dfs(matrix,x,y,m,n,cache);
            max = Math.max(max,len);
        }

        cache[i][j] = max;
        return max;
    }



    /*

    Graph theory, Java solution, O(v^2), no DFS
    https://leetcode.com/problems/longest-increasing-path-in-a-matrix/discuss/78336/Graph-theory-Java-solution-O(v2)-no-DFS

    http://www.allenlipeng47.com/blog/index.php/2016/01/22/longest-increasing-path-in-a-matrix/


     */


    public static int longestIncreasingPath_Graph_Algorithm(int[][] matrix){
        if(matrix == null || matrix.length == 0
                || matrix[0] == null || matrix[0].length == 0){
            return 0;
        }

        int n = matrix.length, m = matrix[0].length,count = m*n, ans = 0;

        while(count>0){
            HashSet<Point> remove = new HashSet<Point>();

            for(int i=0;i<n;i++){

                for( int j = 0; j<m;j++){
                    if( matrix[i][j] == Integer.MIN_VALUE)
                        continue;

                    boolean up = ( i == 0 || matrix[i][j] >= matrix[i-1][j]);
                    boolean bottom = ( i == n-1 || matrix[i][j] >= matrix[i+1][j]);
                    boolean left = (j ==0 || matrix[i][j] >= matrix[i][j-1]);
                    boolean right = (j == m-1 || matrix[i][j] >= matrix[i][j+1]);

                    if( up && bottom && left && right)
                        remove.add(new Point(1,j));
                }
            }

            for (Point point: remove){
                matrix[point.x][point.y] = Integer.MIN_VALUE;
                count--;
            }

            ans ++;
        }


        return ans;

    }




































}