// Title:            Hello World
// Files:            HelloWorld.java
// Semester:         Spring 2019
//
// Author:           Adam Schlondrop
// Email:            schlondrop@wisc.edu
// Lecturer's Name:  Jim Williams

import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a string: ");

        if (s.hasNextLine()) {
            String str = s.nextLine();
            if (!str.equals("")) {
                System.out.println("Hello, " + str + "!");
            } else {
                System.out.println("Hello, world!");
            }
        } else {
            System.out.println("Hello, world!");
        }
    }
}