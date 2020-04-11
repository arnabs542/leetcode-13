/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/4/1
 */
public class LC_14_Longest_Common_Prefix {

    public String longestCommonPrefix(String[] strs){
        if(strs == null || strs.length==0){
            return "";
        }

        for(int i=0;i<strs[0].length();i++){
            char c = strs[0].charAt(i);
            for(int j=0;j<strs.length;j++){
                if(i == strs[j].length() || strs[j].charAt(i)!=c){
                    return strs[0].substring(0,i);
                }
            }
        }

        return strs[0];
    }
}