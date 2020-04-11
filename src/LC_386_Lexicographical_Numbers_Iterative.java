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
 * @created 20/2/15
 */
public class LC_386_Lexicographical_Numbers_Iterative {

    /*


    The basic idea is to find the next number to add.
Take 45 for example: if the current number is 45, the next one will be 450 (450 == 45 * 10)(if 450 <= n), or 46 (46 == 45 + 1) (if 46 <= n) or 5 (5 == 45 / 10 + 1)(5 is less than 45 so it is for sure less than n).
We should also consider n = 600, and the current number = 499, the next number is 5 because there are all "9"s after "4" in "499" so we should divide 499 by 10 until the last digit is not "9".
It is like a tree, and we are easy to get a sibling, a left most child and the parent of any node.


     */
    public List<Integer> lexicalOrder(int n){
        List<Integer> list = new ArrayList<>();
        int cur= 1;
        for(int i = 1;i<=n;i++){
            list.add(cur);
            if(cur*10<=n){
                cur = cur*10;
            }else if (cur%10 !=9 && cur +1 <=n){
                cur++;
            }else{
                while((cur/10)%10 == 9){
                    cur = cur/10;
                }
                cur = cur/10 +1;
            }
        }

        return list;

    }

}