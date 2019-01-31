package com.schlondrop.piglatin;
import java.util.Scanner;

/*converts string (eventually a file) into pig-Latin
*   RULES:
*   1. if start with constant, all constants until first vowel moved to end
*   2. if starts with vowel don't move
*   3. suffix with -ay
*/

public class Main {

	private static final char[] STRING_VOWELS = {'a', 'e', 'i', 'o', 'u'};
	private static String userString = "";
	
    public static void main(String[] args) {
    	String convertedWords = "";
    	ConvertPigLatin pl = new ConvertPigLatin(getUserString(), getUserString().split(" "), convertedWords);
    	
    	
        System.out.println("Enter string to translate:");
        Scanner scnr = new Scanner(System.in);
        
        
        userString += scnr.nextLine();
        String[] words = userString.split(" ");
        
        int count = 0;
        for (String word : words) {
        	String[] parts = pl.getParts(word, STRING_VOWELS);
        	convertedWords += pl.ConcatWord(parts[0], parts[1]);
        	count++;
            if(count != words.length) {
                convertedWords += " ";
            }
            else {
                break;
            }
        }
        

        System.out.println(convertedWords);
        scnr.close();
    }
    
    /*
    public static String Convert(ConvertPigLatin pl, String[] parts) {
		System.out.println("STUB OF STRING CONVERTER");
		
		return "";
	}
	*/
    
    public static String getUserString() {
		return userString;
	}
	
    
}
