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
public class LC_160_Intersecion_Two_list {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if( headA == null || headB == null){
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;

        while( a != b){
            if ( a == null){
                a = headB;
            }else{
                a = a.next;
            }

            if( b == null){
                b = headA;
            }else{
                b = b.next;
            }
        }

        return a;

    }

















}