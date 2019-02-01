package com.schlondrop.practice2;

import javax.swing.*;
import java.util.Scanner;

public class PigLatinWord {

    private String word;
    private String firstVowel;
    private String ending;
    private final String AY = "ay";
    private final char[] VOWELS = {'a', 'e', 'i', 'o', 'u'};

    public PigLatinWord(String word) {
        this.word = word.trim();

        int index = 0;
        while(!isVowel(this.word.toLowerCase().charAt(index))) {
            index++;
        }

        this.firstVowel = this.word.substring(index);
        this.ending = this.word.substring(0, index);
    }

    private boolean isVowel(char c) {
        for (char vowel : VOWELS) {
            if(c == vowel) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.firstVowel + this.ending + this.AY;
    }

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
