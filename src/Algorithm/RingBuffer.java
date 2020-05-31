/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package Algorithm;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/5/31
 */
public class RingBuffer {

    /*

    https://stackoverflow.com/questions/25204494/lock-free-memory-reclamation-with-hazard-pointers

    https://embedjournal.com/implementing-circular-buffer-embedded-c/

    https://en.jinzhao.wiki/wiki/Circular_buffer

    http://wiki.c2.com/?CircularBuffer


    https://preshing.com/20120710/memory-barriers-are-like-source-control-operations/


    https://stackoverflow.com/questions/871234/circular-lock-free-buffer

    A lockless ring-buffer
    https://lwn.net/Articles/340400/
    https://www.kernel.org/doc/Documentation/trace/ring-buffer-design.txt

    https://blog.codingnow.com/2012/02/ring_buffer.html


    https://www.linuxjournal.com/content/lock-free-multi-producer-multi-consumer-queue-ring-buffer

    http://ifeve.com/ringbuffer/


    One common way to deal with this, when using 2 pointers,
    is to only allow the buffer to hold (size − 1) items.
    When both pointers are equal, the buffer is empty,
    and when the end pointer is one less than the start pointer, the buffer is full.

     */

    private Object[] buffer;
    int head;
    int tail;

    int maxLen;



    RingBuffer(int maxLen){
        buffer = new Object[maxLen];
        maxLen = maxLen;
    }


    int push(Object o){
        int next = this.head +1;
        if(next >= this.maxLen){
            next=0;
        }

        if(next == this.tail){
            return -1;
        }

        this.buffer[head] = o;
        this.head = next;
        return 0;
    }


    Object pop(){
        int next;
        if(this.head == this.tail){
            return null;
        }

        next = tail +1;
        if(next >= maxLen){
            next =0;
        }
        this.tail = next;
        return this.buffer[tail];
    }

}