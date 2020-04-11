/*
 * Copyright (c) 2018 maoyan.com
 * All rights reserved.
 *
 */

import java.util.concurrent.TimeUnit;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 18/5/14
 */
public class TokenBucket {
    int capacity;
    int tokensPerSeconds;
    int tokens =0;
    long timestamp = System.currentTimeMillis();

    public TokenBucket(int tokensPerUnit,TimeUnit unit){
        capacity = tokensPerSeconds = (int) (tokensPerUnit/unit.toSeconds(1L));
    }

    public boolean take(){
        long now = System.currentTimeMillis();
        tokens += (int)((now - timestamp)*tokensPerSeconds/1000);
        if( tokens > capacity) tokens = capacity;
        timestamp = now;
        if(tokens < 1)
            return false;
        tokens--;
        return true;
    }

    public static void main(String[] args) throws InterruptedException{
        TokenBucket  bucket = new TokenBucket(250,TimeUnit.MINUTES);

        Thread.sleep(1000L);
        for(int i=0;i<5;i++){
            System.out.println(bucket.take());
        }

        Thread.sleep(1000L);
        for(int i=0;i<5;i++){
            System.out.println(bucket.take());
        }
    }


    /*


    rate = 5.0; // unit: messages
    per  = 8.0; // unit: seconds
    allowance = rate; // unit: messages
    last_check = now(); // floating-point, e.g. usec accuracy. Unit: seconds

    when (message_received):
    current = now();
    time_passed = current - last_check;
    last_check = current;
    allowance += time_passed * (rate / per);
    if (allowance > rate):
    allowance = rate; // throttle
    if (allowance < 1.0):
    discard_message();
    else:
    forward_message();
    allowance -= 1.0;




     */




}