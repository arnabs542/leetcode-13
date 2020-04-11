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
public class LC_386_Lexicographical_Numbers_DFS {

    /**
     *
     *
     * The idea is pretty simple. If we look at the order we can find out we just keep adding digit from 0 to 9 to every digit and make it a tree.
     Then we visit every node in pre-order.
     1        2        3    ...
     /\        /\       /\
     10 ...19  20...29  30...39   ....
     * @param n
     * @return
     */
    public List<Integer> lexicalOrder(int n){
        List<Integer> res = new ArrayList<>();
        for(int i = 1; i<10;++i){
            dfs(i,n,res);
        }
        return res;
    }

    public void dfs(int root, int n , List<Integer> res){
        if(root>n){
            return;
        }

        res.add(root);

        int nextRoot = root*10;
        for(int i=0;i<10;i++){
            if(nextRoot +i >n)
                return;
            dfs(nextRoot+i,n,res);
        }

    }
}