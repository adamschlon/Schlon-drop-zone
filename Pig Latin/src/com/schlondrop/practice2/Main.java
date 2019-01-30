package com.schlondrop.practice2;
import java.util.Scanner;

/*converts string (eventually a file) into pig-Latin
*   RULES:
*   1. if start with constant, all constants until first vowel moved to end
*   2. if starts with vowel don't move
*   3. suffix with -ay
*/

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter string to translate:");
        Scanner scnr = new Scanner(System.in);
        
        char[] stringVowels = {'a', 'e', 'i', 'o', 'u'};  
        String suffix = "ay";
        String userString = "";
        String newString = "";
        
        userString += scnr.nextLine();
        String[] words = userString.split(" ");
        
        int count = 0;
        for (String word : words) {
            newString += convertToPiglatin(word, suffix, stringVowels);
            if(count != words.length) {
                newString += " ";
            }
            else {
                break;
            }
        }
        
        System.out.println("Output: " + newString + "\n");
        scnr.close();
    }
    
    public static String convertToPiglatin(String preConverted, String ending, char[] vowels) {
        //input converted to pig latin then returned
        String convertedWord = "";
        boolean isVowel = false;
        String tempEnd = "";
        for(int i = 0; i < preConverted.length(); i++) {
            for(int j = 0; j < vowels.length; j++) {
                if(preConverted.toCharArray()[i] != vowels[j]) {
                    isVowel = false;
                }
                else {
                   isVowel = true;
                   break;
                }
            }
            
            if(isVowel == false) {
                tempEnd += preConverted.toCharArray()[i];
            }
            else {
                convertedWord += preConverted.substring(i, preConverted.length());
                break;
            }
            
        }
        convertedWord += tempEnd;
        convertedWord += ending;
        return convertedWord;
    }
}
