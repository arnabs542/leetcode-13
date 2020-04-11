/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/1/19
 */
public class LC_56_MergeInterval {

    // 线段的start 将空间切割成不overlap的空间



    private class Interval {
        int start;
        int end;

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }
    }

    private class IntervalComparator implements Comparator<Interval>{

        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start - o2.start;
        }
    }

    public List<Interval> merge(List<Interval> intervals){
        Collections.sort(intervals,new IntervalComparator());
        Collections.sort(intervals,(a,b) -> a.start-b.start);
        Collections.sort(intervals,(a,b) -> Integer.compare(a.start,b.start));

        LinkedList<Interval> merged = new LinkedList<Interval>();


        for(Interval interval: intervals){
            if(merged.isEmpty() || merged.getLast().getEnd() < interval.getStart()){
                merged.add(interval);
            }
            else{
                merged.getLast().end = Math.max(merged.getLast().end,interval.end);
            }
        }

        return merged;

    }


    public int[][] merge (int[][] intervals){
        if(intervals.length <= 1){
            return intervals;
        }

        Arrays.sort(intervals,(i1,i2) -> Integer.compare(i1[0],i2[0]) );
        List<int[]> result = new ArrayList<>();

        int[] newInteral = intervals[0];

        result.add(newInteral);

        for(int[] interval: intervals){
            if(interval[0] <= newInteral[1]){
                newInteral[1] = Math.max(newInteral[1],interval[1]);
            }else{
                newInteral = interval;
                result.add(newInteral);
            }
        }

        return result.toArray(new int[result.size()][]);
    };




}

