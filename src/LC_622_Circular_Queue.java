/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/5/31
 */
public class LC_622_Circular_Queue {
    /*

    https://leetcode.com/problems/design-circular-queue/

    https://leetcode.com/problems/design-circular-queue/discuss/149420/Concise-Java-using-array

     */

    class MyCircularQueue {
        final int[] a;

        int front,rear = -1,len=0;

        public MyCircularQueue(int k) {
            a = new int[k];
        }

        public boolean enQueue(int value) {
            if(!isFull()){
                rear = (rear+1)%a.length;
                a[rear] = value;
                len++;
                return true;
            }else{
                return false;
            }
        }

        public boolean deQueue() {
            if(!isEmpty()){
                front = (front+1)%a.length;
                len --;
                return true;
            }else{
                return false;
            }
        }

        public int Front() {
            return isEmpty()?-1:a[front];
        }


        public int Rear() {
            return isEmpty()?-1:a[rear];
        }


        public boolean isEmpty() {
            return len==0;
        }

        public boolean isFull() {
            return len==a.length;
        }
    }


}