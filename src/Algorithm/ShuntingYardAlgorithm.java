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
public class ShuntingYardAlgorithm {

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


    /*


        https://github.com/brettshollenberger/shunting-yard-algorithm

        https://eddmann.com/posts/shunting-yard-implementation-in-java/

        https://github.com/ekg/shuntingyard/blob/master/shuntingyard.py


        while (another token exists):
          if (token is an operand):
            enqueue it in the output queue
          else:
            if (token is a left-parend):
              push it onto the operations stack
            else (if token is a right-parend):
              while the top operation is not a left-parend:
                pop off the top operation and enqueue it to output
              end

              pop off the left-parend and throw it away
            else (if token is another supported operation):
              while its precedence is lower than the top-most operation:
                pop off the top-most op and enqueue it to output
              end

              push the operation onto the stack
            end
          end
        end



     */

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




    /*

    http://faculty.cs.niu.edu/~hutchins/csci241/eval.htm


     Start with an empty stack.  We scan Q from left to right.

     While (we have not reached the end of Q)
        If (an operand is found)
           Add it to P
        End-If
        If (a left parenthesis is found)
           Push it onto the stack
        End-If
        If (a right parenthesis is found)
           While (the stack is not empty AND the top item is
                  not a left parenthesis)
              Pop the stack and add the popped value to P
           End-While
           Pop the left parenthesis from the stack and discard it
        End-If
        If (an operator is found)
           If (the stack is empty or if the top element is a left
               parenthesis)
              Push the operator onto the stack
           Else
              While (the stack is not empty AND the top of the stack
                     is not a left parenthesis AND precedence of the
                     operator <= precedence of the top of the stack)
                 Pop the stack and add the top value to P
              End-While
              Push the latest operator onto the stack
           End-If
        End-If
     End-While
     While (the stack is not empty)
        Pop the stack and add the popped value to P
     End-While

     */








}