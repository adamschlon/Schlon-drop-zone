package com.schlondrop.jakeclasses;

import java.util.Scanner;

public class JakeMain {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] a = s.split(" ");

        PigLatinWord[] words = new PigLatinWord[a.length];

        for (int i = 0; i < a.length; i++) {
            words[i] = new PigLatinWord(a[i]);
        }

        for (PigLatinWord word : words) {
            System.out.print(word + " ");
        }
    }
    
}
