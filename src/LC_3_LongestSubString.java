/*
 * Copyright (c) 2019 maoyan.com
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
 * @created 19/9/22
 */
public class LC_3_LongestSubString {
    // substring 遍历法: 从头至尾组合 N*2 ,每个长度是N，时间复杂度 N^3 ,
    // 优化
    public int legthOfLongestSubString(String s){
        int result = bruteForce(s);

        return result;

    }

    public int bruteForce(String s){
        int n = s.length();
        int lns = 0;
        for(int i = 0; i<n;i++)
            for(int j = i+1;j<=n;j++)
                if(allUnique(s,i,j)){
                    lns = Math.max(lns,j-i);
                }

        return lns;
    }

    public boolean allUnique(String s,int start,int end){
        Set<Character> set = new HashSet<Character>();
        for(int i = start;i<end;i++){
            Character ch = s.charAt(i);
            if(set.contains(ch))
                return false;
            set.add(ch);
        }
        return true;
    }

    public int slidingWindowWithOneStep(String s){
        Set<Character> set = new HashSet<Character>();
        int lns = 0;
        int n = s.length();
        int j = 0;
        for(int i=0;i<n;i++){
            for(;j<n;j++){
                if(set.contains(s.charAt(j))){
                    set.remove(s.charAt(i));
                }else{
                    lns = Math.max(lns,j-i);
                    set.add(s.charAt(j));
                }
            }
        }

        return lns;
    }

    public int slidingWindowWithNStep(String s){
        Map<Character,Integer> stepMap = new HashMap<Character, Integer>();

        int lns = 0;
        int n = s.length();

        for(int j = 0,i =0; j <n ;j++){

            if(stepMap.containsKey(s.charAt(j))){

            }else{

            }
        }
        return n;
    }


}