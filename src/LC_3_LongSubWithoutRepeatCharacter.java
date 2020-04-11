/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/1/22
 */
public class LC_3_LongSubWithoutRepeatCharacter {
    public int lengthOfLongestSubString(String s){
        int n = s.length();

        int ans = 0;

        for( int i = 0; i<n;i++)
            for(int j=i+1;j<=n;j++){
                if(allUnique(s,i,j)){
                    ans = Math.max(ans,(j-i));
                }

            }
        return ans;
    }

    public boolean allUnique(String s ,int start, int end){
        Set<Character> set = new HashSet<>();

        for(int i = start;i<end;i++){
            Character ch = s.charAt(i);
            if(set.contains(ch)){
                return false;
            }
            set.add(ch);
        }

        return true;

    }


    public  int lengthOfLongestSubString_slideWindow(String s){
        int n = s.length();

        Set<Character> set = new HashSet<>();

        int ans =0,i=0,j=0;

        while(i<n && j<n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans,(j-i));
            }else{
                set.remove(s.charAt(i++));
            }
        }
        return ans;

    }


    public int lengthOfLongSub_slideWindow_optimized(String s){
        int n = s.length(),ans = 0;
        Map<Character,Integer> map= new HashMap<>();
        for(int j = 0,i=0; j<n;j++){
            if(map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)),i);
            }

            ans = Math.max(ans,j-i+1);
            map.put(s.charAt(j),j+1);
        }

        return ans;

    }







}