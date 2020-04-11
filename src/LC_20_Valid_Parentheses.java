/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

import java.util.HashMap;
import java.util.Stack;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/4/5
 */
public class LC_20_Valid_Parentheses {
    public boolean isValid(String s) {
        HashMap<Character,Character> mappings = new HashMap<>();
        mappings.put(')','(');
        mappings.put('}','{');
        mappings.put(']','[');

        Stack<Character> stack = new Stack<Character>();

        for( int i = 0; i<s.length();i++){
            char c = s.charAt(i);

            if(mappings.containsKey(c)){
                char topElement = stack.empty() ? '#':stack.pop();
                if(topElement!= mappings.get(c)){
                    return false;
                }
            }else{
                stack.push(c);
            }
        }

        return stack.isEmpty();

    }

}