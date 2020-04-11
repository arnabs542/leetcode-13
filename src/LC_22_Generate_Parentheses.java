/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/1/29
 */
public class LC_22_Generate_Parentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        if( n == 0){
            ans.add("");
        }else{
            for( int c = 0; c<n;++c){
                for(String left: generateParenthesis(c))
                    for(String right: generateParenthesis(n-c-1))
                        ans.add("("+left+")" + right);
            }
        }
        return ans;
    }


    public List<String> generateParent_BackTrack(int n){
        List<String> list = new ArrayList<String>();
        backtrack(list,"",0,0,n);
        return list;
    }

    public void backtrack(List<String> list,String str,int openNum,int closeNum,int maxNum){
        if(str.length() == maxNum*2){
            list.add(str);
            return;
        }
        if(openNum<maxNum){
            backtrack(list,str+"(",openNum+1,closeNum,maxNum);
        }

        if(closeNum<openNum){
            backtrack(list,str+")",openNum,closeNum+1,maxNum);
        }
    }
}