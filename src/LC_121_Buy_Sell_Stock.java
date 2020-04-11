/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/3/30
 */
public class LC_121_Buy_Sell_Stock {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;

        int maxProfit = 0;

        for( int i =0 ;i<prices.length;i++){
            if ( prices[i] < minPrice){
                minPrice = prices[i];
            }else if ( prices[i] - minPrice > maxProfit){
                maxProfit = prices[i] -minPrice;
            }
        }

        return maxProfit;
    }

}