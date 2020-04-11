/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package Algorithm;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 20/2/22
 */
public class ShuntingYardAlgorithm_2 {

    /**
     * \s	A whitespace character: [ \t\n\x0B\f\r]
     * @param args
     */
    public static void main(String[] args){
        String infix = "( 5 + 7 ) * 2 + 3 * 5 - 10 * ( 3 - 5 )";
        System.out.println("infix: "+ infix);
        String postFix = infix2postfix(infix);
        System.out.println("postfix: "+ postFix);
        String value = postEval(postFix);
        System.out.println("value: "+ value);
    }

    public  void testSplit(String infix){

        String[] tokenList = infix.split("\\s");
        for(String token: tokenList){
            System.out.println(token);
        }

    }

    public enum Operator{
        ADD("+",1),
        SUBSTRACT("-",2),
        MULTIPLY("*",3),
        DIVIDE("/",4),
        ;
        final String value;
        final int precedence;
        Operator(String value,int p){
            this.value = value;
            this.precedence=p;
        }

        public int getPrecedence() {
            return precedence;
        }

        public String getValue() {
            return value;
        }
    }

    public static Map<String,Operator> ops = new HashMap<String,Operator>();
    static {
        for(Operator o: Operator.values()){
            ops.put(o.getValue(),o);
        }
    }

    public static boolean hasHigerPrecedence(String op,String stackOp){
        return (ops.containsKey(stackOp) &&
                ops.get(stackOp).getPrecedence() >= ops.get(op).getPrecedence());
    }


    public static String infix2postfix(String infix){
        StringBuilder output = new StringBuilder();
        Deque<String> stack = new LinkedList<>();

        for(String token: infix.split("\\s")){
            if(ops.containsKey(token)){
                while( !stack.isEmpty() && hasHigerPrecedence(token,stack.peek())){
                    output.append(stack.pop()).append(' ');
                }
                stack.push(token);
            }else if( token.equals("(")){
                stack.push(token);
            }else if ( token.equals(")")){
                while(!stack.peek().equals("(")){
                    output.append(stack.pop()).append(' ');
                }
                stack.pop();
            }else {
                output.append(token).append(' ');
            }
        }
        while ( !stack.isEmpty())
            output.append(stack.pop()).append(' ');


        return output.toString();
    }


    public static String postEval(String postString){
        Stack<String> stack = new Stack<String>();
        for(String value: postString.split("\\s")){
            if(ops.containsKey(value)){
                int value1 = Integer.parseInt(stack.pop());
                int value2 = Integer.parseInt(stack.pop());
                int value3 = eval(value2,value1,value);
                stack.push(String.valueOf(value3));
            }else{
                stack.push(value);
            }
        }

        return stack.pop();
    }

    public static int eval(int value1,int value2,String op){
        if(op .equals(Operator.ADD.getValue()) ){
            return value1 + value2;
        }else if( op.equals(Operator.SUBSTRACT.getValue())){
            return value1 - value2;
        }else if (op .equals(Operator.DIVIDE.getValue()) ){
            return value1/value2;
        }else if ( op .equals(Operator.MULTIPLY.getValue()) ) {
            return value1 * value2;
        }else{
            throw new RuntimeException(value1 + " " + value2 + " " + op);
        }
    }













}