/*
 * Copyright (c) 2018 maoyan.com
 * All rights reserved.
 *
 */

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 18/5/9
 */
public class LC_19_RemoteNthFromEnd {
    public static  class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val=x;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head,int n){

        ListNode dummy = new ListNode(0);
        dummy.next= head;

        if (head==null){
            return head;
        }
        if(n==0){
            return head;
        }
        ListNode firstIterator = dummy;
        for(int i=1; i<n+1;i++){
            firstIterator = firstIterator.next;
        }

        ListNode secondIterator = dummy;

        while(firstIterator!=null){
            firstIterator = firstIterator.next;
            secondIterator = secondIterator.next;
        }

        secondIterator.next = secondIterator.next.next;

        return dummy.next;
    }

    public static void  traversalList(ListNode head){
        if(head==null){
            return;
        }
        ListNode cur = head;
        while(cur!= null){
            System.out.printf("%d ->",cur.val);
            cur = cur.next;
        }
        System.out.printf("\n");
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode cur =head;
        for(int i=2;i<3;i++){
            ListNode listNode = new ListNode(i);
            cur.next = listNode;
            cur = listNode;
        }

        traversalList(head);

        removeNthFromEnd(head, 2);

        traversalList(head);



    }
}