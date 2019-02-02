package com.schlondrop.piglatinV2;

import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {
		String s;												//variables
		String[] wordArray;
		
		Scanner in = new Scanner(System.in);					//create scanner object
/*
 * TODO add file reading capability if user input is file name
 */
		System.out.println("Enter string to convert");			//prompt user
		s = in.nextLine();										//get input
		wordArray = s.split(" ");								//get words in string								
		
		
		
		in.close();
	}
}