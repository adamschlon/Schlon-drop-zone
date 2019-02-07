package com.schlondrop.piglatinV2;

import java.util.Scanner;



/*
 * TODO add file reading capability if user input is file name
 */

public class Main {

    public static Scanner in = new Scanner(System.in);                    //creates objects

    public static String[] wordArray;
    private static String[] choice;


    public static void main(String[] args) {
        String s;                                               //variables

        promptUser(in);

        FileConverter f = new FileConverter(choice);


        if(f.getInput()){
            f.writeFile(in);
        }
        else{
            System.out.println("Enter string to convert");          //prompt user
            s = in.nextLine().toLowerCase();                        //get input
            wordArray = s.split(" ");                         //get words in string

            System.out.println(PigLatin.concatWords());
        }
        in.close();
    }

    public static String[] getWordArray() {
        return wordArray;
    }

    public static String[] promptUser(Scanner in){
        System.out.println("Do you want to convert File or User input: ");
        choice = in.nextLine().toLowerCase().split(" ");
        return choice;
    }
}