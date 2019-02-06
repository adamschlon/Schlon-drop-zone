package com.schlondrop.piglatinV2;

import java.util.Scanner;


/*
 * TODO add file reading capability if user input is file name
 */

public class Main {

    static String[] wordArray;


    public static void main(String[] args) {
        String s;                                               //variables
        Scanner in = new Scanner(System.in);                    //create scanner object
        PigLatin p = new PigLatin("");
        System.out.println("Enter string to convert");          //prompt user
        s = in.nextLine().toLowerCase();                        //get input
        wordArray = s.split(" ");                         //get words in string

        System.out.println(p.concatWords());

        in.close();
    }

    public String[] getWordArray() {
        return wordArray;
    }

}