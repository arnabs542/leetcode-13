/*
 * Copyright (c) 2018 maoyan.com
 * All rights reserved.
 *
 */

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 18/9/4
 */
public class DoubleTest {


    public static void main(String[] args){
        String number = printBinary2(0.72);

        System.out.println(number + "length:"+number.length());
    }

    public static String printBinary2(double num){
        StringBuilder binary = new StringBuilder();

        double frac = 0.5;
        binary.append(".");
        while (num >0){
            if(binary.length()>1000){
                System.out.println(binary.toString()+" "+binary.length());
                return "ERROR";
            }

            if(num>=frac){
                binary.append(1);
                num -=frac;
            }else{
                binary.append(0);
            }

            frac /=2;
        }

        return binary.toString();
    }


}


