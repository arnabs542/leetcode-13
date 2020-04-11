/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

import java.util.ArrayList;
import java.util.Random;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/3/5
 */
public class LC_382_Linked_List_Random_Node {

    /*

    https://leetcode.com/tag/reservoir-sampling/
    https://robinliu.gitbooks.io/leetcode/content/reservoir_sampling.html
    https://en.jinzhao.wiki/wiki/Reservoir_sampling

     */




    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(head);
     * int param_1 = obj.getRandom();
     */

    class Solution {
        private ListNode head;
        private Random rand;

        public Solution(ListNode head) {
            this.head = head;
            this.rand = new Random();
        }


        public int getRandom() {
            int k = 1;
            ListNode node = this.head;
            int res = node.val;
            int i = 0;
            ArrayList<Integer> reservoir = new ArrayList<>();

            while(i<k && node !=null){
                reservoir.add(node.val);
                node = node.next;
                i++;
            }

            i++;
            while ( node !=null){
                int randomIndex = rand.nextInt(i);
                if(randomIndex < k){
                    reservoir.set(randomIndex,node.val);
                }
                i++;
                node = node.next;
            }

            return reservoir.get(0);
        }
    }

















}