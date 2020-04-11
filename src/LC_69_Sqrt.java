/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/3/12
 */
public class LC_69_Sqrt {
    public int mySqrt(int x) {
        if(x == 0){
            return 0;
        }

        int left = 1, right = Integer.MAX_VALUE;

        while(true){
            int mid = left + (right-left)/2;
            if(mid > x/mid){
                right = mid -1;
            }else{
                if(mid+1 > x/(mid+1)){
                    return mid;
                }
                left =mid +1;
            }
        }
    }

}