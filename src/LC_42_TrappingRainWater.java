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
public class LC_42_TrappingRainWater {

    public int trap(int[] height) {
        if(height.length<1){
            return 0;
        }
        int ans = 0;
        for(int i = 0;i<height.length;i++){
            int maxLeft = 0, maxRight = 0;
            for(int j =0;j<i;j++){
                maxLeft = Math.max(maxLeft,height[j]);
            }
            for(int j = i+1;j<height.length;j++){
                maxRight = Math.max(maxRight,height[j]);
            }

            int min = Math.min(maxLeft,maxRight);
            ans = ans + min-height[i];
        }

        return ans;
    }





}