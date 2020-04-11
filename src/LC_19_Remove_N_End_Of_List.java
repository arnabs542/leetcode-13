/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/1/29
 */
public class LC_19_Remove_N_End_Of_List {


    public ListNode removeNthFromEnd(ListNode head,int n){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length=0;
        ListNode first = head;

        while(first!=null){
            length ++;
            first = first.next;
        }

        length = length - n;

        first = dummy;

        while(length>0){
            length --;
            first = first.next;
        }

        first.next = first.next.next;

        return dummy.next;
    }


    public ListNode removeNthFromEnd_One_Pass(ListNode head,int n){
        ListNode dummy  = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;

        for(int i = 1;i<=n+1;i++){
            first = first.next;
        }

        while(first!=null){
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return dummy.next;
    }
}