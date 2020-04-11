/*
 * Copyright (c) 2018 maoyan.com
 * All rights reserved.
 *
 */
package NFA;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 18/9/7
 */
public class ExpMN {
    int pow(int m, int n){
        if(0 == n) return 1;
        if(n%2==1) {
            return m * pow(m, n/2) * pow(m, n/2);
        }else{
            return pow(m,n/2)*pow(m,n/2);
        }
// 有问题，看起来很美好，还是O(N)的算法
    }

}