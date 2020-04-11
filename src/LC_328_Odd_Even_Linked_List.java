/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/3/8
 */
public class LC_328_Odd_Even_Linked_List {
    public ListNode oddEvenList(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode odd = head, even = head.next,evenHead = even;

        while(even !=null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }
















}