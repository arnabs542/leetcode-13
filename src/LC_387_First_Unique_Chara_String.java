/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

import java.util.HashMap;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/4/11
 */
public class LC_387_First_Unique_Chara_String {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> count = new  HashMap<Character,Integer>();
        int n = s.length();

        for( int i = 0 ;i<n;i++){
            char c = s.charAt(i);
            count.put(c,count.getOrDefault(c,0)+1);
        }

        for( int i=0;i<n;i++){
            if(count.get(s.charAt(i)) == 1){
                return i;
            }
        }

        return -1;
    }




























}