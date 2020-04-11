/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/1/22
 */
public class LC_11_ContainerWIthMostWater {
    public int maxArea(int[] height) {
        int maxarea = 0;

        for(int i = 0;i<height.length;i++)
            for(int j = i+1;j<height.length;j++)
                maxarea = Math.max(maxarea,Math.min(height[i],height[j])*(j-i));

        return maxarea;
    }


    public int maxArea_two_pointer(int[] height){
        int maxarea = 0,l=0,r= height.length -1;

        while(l<r){
            maxarea = Math.max(maxarea,
                    Math.min(height[l],height[r])*(r-l));
            if(height[l] < height[r]){
                l++;
            }else{
                r--;
            }

        }

        return maxarea;
    }




}