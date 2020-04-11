/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/4/5
 */
public class LC_21_Merge_Two_Sorted_List {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if( l1 == null) return l2;
        if( l2 == null) return l1;

        if( l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoLists_Iteration(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode handler = head;
        while(l1 !=null && l2 != null){
            if( l1.val <= l2.val){
                handler.next = l1;
                l1 = l1.next;
            }else{
                handler.next = l2;
                l2 = l2.next;
            }

            handler = handler.next;
        }

        if(l1 != null){
            handler.next = l1;
        }else if ( l2 != null){
            handler.next = l2;
        }

        return head.next;
    }
}