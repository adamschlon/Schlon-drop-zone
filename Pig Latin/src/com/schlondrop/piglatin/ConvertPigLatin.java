package com.schlondrop.piglatin;

public class ConvertPigLatin {
	
	String sentence;
	String[] words;
	String convertedWords;
	
	public ConvertPigLatin(String sentence, String[] words, String convertedWords) {
		this.sentence = sentence;
		this.words = words;
		this.convertedWords = convertedWords;
	}
	
	public String getSentence() {
		return sentence;
	}
	
	public String[] getWords() {
		return words;
	}
	
	public void setConvertedWords(String convertedWords) {
		this.convertedWords = convertedWords;
	}
	
	
	public String ConcatWord(String segment, String constonants) {
		String convertedWord = "";
		String suffix = "ay";
		convertedWord += segment + constonants + suffix;
		return convertedWord;
	}
	
	public String[] getParts(String preConverted, char[] vowels) {
		
		String tempStart = "";
		String tempEnd = "";
		
		boolean isVowel = false;
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
                tempStart += preConverted.substring(i, preConverted.length());
                break;
            }
            
        }
        String[] parts = {tempStart, tempEnd};
		
		return parts;
	}
	
	
}
