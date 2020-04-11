/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/2/2
 */
public class LC_152_Maximum_Product_Subarray {
    public int maxProduct(int[] nums) {
        int r = nums[0];

        for(int i =1,imax = r,imin = r; i<nums.length;i++){
            int tempMax = imax*nums[i];
            int tempMin = imin*nums[i];

            imax = Math.max(Math.max(nums[i],tempMax),tempMin);
            imin = Math.min(Math.min(nums[i], tempMax), tempMin);

            r = Math.max(r,imax);
        }

        return r;
    }

    class Tuple {
        private int imax;
        private int imin;
        private Tuple(int imax, int imin) {
            this.imax = imax;
            this.imin = imin;
        }
    }



    /*
    very nice . I guess a bit of more explanation
    would help people understand:

    this is very similar to the " max cumulative sum subarray" problem.
    here you keep 2 values: the max cumulative product UP TO
    current element starting from SOMEWHERE in the past,
    and the minimum cumuliative product UP TO current element .
    it would be easier to see the DP structure if we store
    these 2 values for each index, like maxProduct[i],minProduct[i] .

    at each new element, u could either add the new element to the existing product,
    or start fresh the product from current index (wipe out previous results),
    hence the 2 Math.max() lines.

    if we see a negative number, the "candidate" for max should instead
    become the previous min product, because a bigger number multiplied
    by negative becomes smaller, hence the swap()

     */
    public int maxProduct_DP(int[] nums) {
        Tuple[] dp = new Tuple[nums.length];
        dp[0] = new Tuple(nums[0],nums[0]);

        int res =dp[0].imax;

        for(int i = 1;i<nums.length;i++){
            Tuple prev = dp[i-1];
            int imax = Math.max(Math.max(nums[i],nums[i]*prev.imax),nums[i]*prev.imin);
            int imin = Math.min(Math.min(nums[i],nums[i]*prev.imax),nums[i]*prev.imin);
            dp[i] = new Tuple(imax,imin);

            res = Math.max(imax,res);
        }

        return res;
    }






















}
