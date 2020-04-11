/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/4/5
 */
public class LC_13_Roman_To_Integer {
    public int romanToInt(String s) {
        if(s == null || s.length() == 0 ){
            return 0;
        }

        Map<Character,Integer> map = new HashMap<>();

        map.put('M',1000);
        map.put('D',500);
        map.put('C',100);
        map.put('L',50);
        map.put('X',10);
        map.put('V',5);
        map.put('I',1);

        int sum =0;
        int prev = map.get(s.charAt(0));
        int next = 0;

        for(int i=1;i<s.length();i++){
            next = map.get(s.charAt(i));

            if( prev < next){
                sum = sum - prev;
            }else{
                sum = sum + prev;
            }

            prev = next;
        }

        sum = sum + prev;
        return sum;
    }

}