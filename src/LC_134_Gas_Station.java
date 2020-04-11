/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/2/2
 */
public class LC_134_Gas_Station {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int total = 0;
        int tank = 0;

        for(int i =0; i<gas.length;i++){
            tank = tank + gas[i] - cost[i];
            if(tank<0){
                start = i+1;
                total = total + tank;
                tank = 0;
            }
        }

        return (total + tank < 0) ? -1:start;

    }

}