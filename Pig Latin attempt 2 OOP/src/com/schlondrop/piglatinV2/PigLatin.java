package com.schlondrop.piglatinV2;

public class PigLatin {
    final char[] VOWELS = "aeiou".toCharArray();
    private String word;                            //initialize variables
    private String ending;
    private String consonants;
    final private String SUFFIX = "ay";
    private String convertedWord = "";


    Main m = new Main();

    public PigLatin(String word) {                    //constructors
        this.word = word.trim();
    }

    public String convertWord() {
        boolean status = false;
        char[] c = this.word.toCharArray();
        for (int i = 0; i < c.length; i++) {
            for (int k = 0; k < VOWELS.length; k++) {
                if (c[i] == VOWELS[k]) {
                    //System.out.println(i);
                    consonants = this.word.substring(0, i);
                    ending = this.word.substring(i, c.length);
                    status = true;
                    break;
                }
            }
            if (status) {
                break;
            }
        }
        convertedWord = convertedWord.concat(ending + consonants + SUFFIX);
        return convertedWord;
    }

    public String concatWords() {
        String convertedString = "";
        for (String word : m.getWordArray()) {
            PigLatin pl = new PigLatin(word);
            convertedString += pl.convertWord() + " ";
        }
        return convertedString;
    }


}
