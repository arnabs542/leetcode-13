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
public class LC_122_Buy_And_Sell_Stock_2 {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for( int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                maxProfit +=prices[i] - prices[i-1];
            }
        }

        return maxProfit;
    }


}