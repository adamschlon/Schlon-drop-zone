package com.schlondrop.piglatin;

public class ConvertPigLatin {

	/*
	TODO | This is a pretty good idea on how a class should be designed, just some minor things that you don't need to do.
	TODO |
	TODO | Firstly, in the constructor, you don't need to pass in both the full sentence and it's words. If you want to get
	TODO | the words from the sentence, do it within this class in one of the method implementations or within the constructor.
	TODO |
	TODO | Secondly, your methods in this class are more what you'd find in a namespace and not a class.
	TODO | (Namespace = an area of defined functions and fields that can be used as "tools").
	TODO | Your functions should instead modify the fields within this class. For example, in the constructor write the
	TODO | algorithm for converting the words to pig latin instead of relying on the main method, which is outside this class,
	TODO | to call a method to change variables passed into the method.
	TODO |
	TODO | If you wanted to do that, you could just move that method into Main.java and make it static.
	TODO |
	TODO | I guess a good way to think about classes and objects is by example:
	TODO | Lets say we want our program to have Cars. We would create a class named "Car" where it would contain
	TODO | properties/attributes that any car would have: model, make, front/rear wheel drive, etc.
	TODO | By instantiating an object of type "Car" we can specify that Car as a "Ford Explorer, front wheel drive".
	TODO | These attributes would be set using the constructor. We could then have methods in the class like
	TODO | drive(), brake(), openDoor(), etc.
	TODO |
	TODO | Hopefully this helps?
	 */

	/*
	TODO | Also, although it isn't necessary, you should explicity state any non-final fields to be private.
	 */

	String sentence;
	String[] words;
	String convertedWords; // TODO | This field is never used for anything??????

	// TODO | What I suggest your constructor signature to be:
//	public ConvertPigLatin(String sentence);
	
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
	
	/* TODO | Method shouldn't be capitalized, this isn't C# you heretic ;) */
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
