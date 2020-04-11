/*
 * Copyright (c) 2018 maoyan.com
 * All rights reserved.
 *
 */
package NFA;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 在这里编写类的功能描述
 *
 * @author guozhaoliang
 * @created 18/7/6
 */
public class Grep {

    public static void main(String[] args) throws FileNotFoundException {

        String regexp = "(.*" + args[0] + ".*";
        NFA nfa = new NFA(regexp);
        String fileName = args[1];
        Scanner in = new Scanner(new File(fileName));
        long line =0;
        while(in.hasNextLine()){
            line++;
            String text = in.nextLine();
            if(nfa.recognizes(text)){
                System.out.println(text+"\t"+line);
            }
        }
    }
}