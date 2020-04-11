/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package Offer;
/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/4/7
 */
public class Double_Linked_List {

    /*

        https://www.nowcoder.com/questionTerminal/947f6eb80d944a84850b0538bf0ec3a5?answerType=1&f=discussion


     */




    /*

    链接：https://www.nowcoder.com/questionTerminal/947f6eb80d944a84850b0538bf0ec3a5?answerType=1&f=discussion
    来源：牛客网

     */


    public class Solution {
        TreeNode pre=null;
        public TreeNode Convert(TreeNode pRootOfTree) {
            if(pRootOfTree==null)
                return null;
            Convert(pRootOfTree.right);
            if(pre==null)
                pre=pRootOfTree;
            else{
                pRootOfTree.right=pre;
                pre.left=pRootOfTree;
                pre=pRootOfTree;
            }
            Convert(pRootOfTree.left);
            return pre;
        }
    }


    /*
    链接：https://www.nowcoder.com/questionTerminal/947f6eb80d944a84850b0538bf0ec3a5?answerType=1&f=discussion
来源：牛客网

再想，我们受到惯性思维的约束，每次都是想着中序遍历先遍历左子树，再遍历根节点，
再遍历右子树。那既然第二种方法得到的二叉树是降序的，那我先遍历右子树，再遍历根节点，
再遍历左子树不就可以了么，所以有了 第三种解法，代码和第二种大致一样：

     */


    public class Solution_2 {
        TreeNode pre=null;
        public TreeNode Convert(TreeNode pRootOfTree) {
            if (pRootOfTree==null)
                return null;
            Convert(pRootOfTree.right);
            if (pre!= null){
                pRootOfTree.right=pre;
                pre.left=pRootOfTree;
            }
            pre=pRootOfTree;
            Convert(pRootOfTree.left);
            return pre;
        }
    }

    /*
        链接：https://www.nowcoder.com/questionTerminal/947f6eb80d944a84850b0538bf0ec3a5?answerType=1&f=discussion
    来源：牛客网

    链接：https://www.nowcoder.com/questionTerminal/947f6eb80d944a84850b0538bf0ec3a5?answerType=1&f=discussion
来源：牛客网

接着想怎么优化。我们知道二叉排序树中序遍历的结果是排好序的，然后再想到线索化二叉树的过程，
很容易联想到用线索化二叉树的方法去做，用一个全局变量去保存前一个节点，
然后再去创建节点之间的关系（这里区别与线索化二叉树的是，
线索化二叉树创建节点之间的关系是在节点的左右孩子为空的时候采取创建，
这样二叉树还是二叉树。但是这里就不是，只要pre不空，就创建关系，创建后就是链表了，二叉树被破坏了）。
这里推荐一下我自己写的有关二叉树的博客:https://blog.csdn.net/qq_31709249/article/details/103092783。
这里面有详细讨论二叉树的各种问题（其他的数据结构也有讨论，也可以看看）。
那参考线索化二叉树的创建过程，我们的代码应该是这样子的：

这里我们发现返回的双向链表是降序排列的，那我们有两种解决方法，
第一种是再遍历一遍得到的结果，将节点的最后一个结果返回。
第二种是设置一个变量来记录，我 这里采用第二种方法:

     */



    public class Solution_3 {
        TreeNode pre=null;
        public TreeNode Convert(TreeNode pRootOfTree) {
            if (pRootOfTree==null)
                return null;
            Convert(pRootOfTree.left);
            if (pre!= null){
                pRootOfTree.left=pre;
                pre.right=pRootOfTree;
            }
            pre=pRootOfTree;
            Convert(pRootOfTree.right);
            return pre;
        }
    }

    public class Solution_4 {
        TreeNode pre=null;
        TreeNode root=null;
        public TreeNode Convert(TreeNode pRootOfTree) {
            if (pRootOfTree==null)
                return null;
            Convert(pRootOfTree.left);
            if (root==null){
                root=pRootOfTree;
            }
            if (pre!= null){
                pRootOfTree.left=pre;
                pre.right=pRootOfTree;
            }
            pre=pRootOfTree;
            Convert(pRootOfTree.right);
            return root;
        }
    }


}