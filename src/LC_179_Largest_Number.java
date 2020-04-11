/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

import java.util.Arrays;
import java.util.Comparator;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/2/2
 */
public class LC_179_Largest_Number {

    private class LargerNumberComparator implements Comparator<String>{

        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b+a;
            return order2.compareTo(order2);
        }
    }

    public String largestNumber(int[] nums){
        String[] asStrs = new String[nums.length];

        for(int i = 0; i<nums.length; i++){
            asStrs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(asStrs,new LargerNumberComparator());

        if(asStrs[0].equals("0")){
            return "0";
        }

        String largestNumberStr = new String();

        for(String numAsStr: asStrs){
            largestNumberStr += numAsStr;
        }

        return largestNumberStr;
    }


















}