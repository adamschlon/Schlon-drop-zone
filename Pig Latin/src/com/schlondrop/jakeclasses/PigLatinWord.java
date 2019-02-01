package com.schlondrop.jakeclasses;

public class PigLatinWord {

    /*
    Instead of having mine be an object of an entire sentence, I just made it into an object of one pig latin word.
     */

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

}
