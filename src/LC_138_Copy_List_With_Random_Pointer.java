/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/4/12
 */
public class LC_138_Copy_List_With_Random_Pointer {

    /*
    https://leetcode.com/problems/copy-list-with-random-pointer/

    https://leetcode.com/problems/copy-list-with-random-pointer/discuss/43488/Java-O(n)-solution

    https://leetcode.com/problems/copy-list-with-random-pointer/discuss/43491/A-solution-with-constant-space-complexity-O(1)-and-linear-time-complexity-O(N)

     */
    public Node copyRandomList_By_Map(Node head) {
        if( head == null){
            return null;
        }

        Map<Node,Node> map = new HashMap<Node,Node>();

        Node node = head;

        while(node!=null){
            map.put(node,new Node(node.val));
            node=node.next;
        }

        node = head;

        while(node != null){
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }

        return map.get(head);
    }

























}