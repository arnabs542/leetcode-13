/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/3/30
 */
public class LC_237_Delete_Node {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;

        node.next = node.next.next;
    }
}