/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/3/8
 */
public class LC_341_Flatten_Nested_List {


    public interface NestedInteger{
        public boolean isInteger();
        public Integer getInteger();
        public List<NestedInteger> getList();
    }

    /*
        Input: [[1,1],2,[1,1]]
        Output: [1,1,2,1,1]


        Input: [1,[4,[6]]]
        Output: [1,4,6]



     */
    public class NestedIterator implements Iterator<Integer> {
        private Stack<Iterator<NestedInteger>> stack;
        private NestedInteger nextInt;
        public NestedIterator(List<NestedInteger> nestedList) {
            this.stack = new Stack<Iterator<NestedInteger>>();
            this.stack.push(nestedList.iterator());
            this.nextInt = null;
        }

        @Override
        public Integer next() {
            Integer ret = nextInt !=null ? nextInt.getInteger():null;
            nextInt = null;
            return ret;
        }

        @Override
        public boolean hasNext() {
            if(nextInt !=null)
                return true;

            while(!stack.isEmpty()){
                if(!stack.peek().hasNext()){
                    stack.pop();
                }else if ((nextInt = stack.peek().next()).isInteger()){
                    return true;
                }else {
                    stack.push(nextInt.getList().iterator());
                }

            }

            return false;
        }
    }















}