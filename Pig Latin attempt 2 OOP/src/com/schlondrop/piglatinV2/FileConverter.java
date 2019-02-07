package com.schlondrop.piglatinV2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class FileConverter {
    private String[] choice;
    boolean status = false;
    private boolean option;
    private static File inputFile = new File("inputFile.txt");

    public FileConverter(String[] choice) {
        this.choice = choice;
        try {
            if(!inputFile.exists()){inputFile.createNewFile();}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean getInput() {
        Main m = new Main();
        while (true) {

            for (int i = 0; i < this.choice.length; i++) {
                if (this.choice[i].equals("file")) {
                    option = true;
                    status = true;
                    break;
                } else if (choice[i].equals("user") || choice[i].equals("input")) {
                    option = false;
                    status = true;
                    break;
                } else {
                    if (i == this.choice.length - 1) {
                        System.out.println("Response could not be understood");
                        status = false;
                        this.choice = m.promptUser(Main.in);
                    }
                }
            }
            if (status) {
                break;
            }
        }
        return option;
    }

    public void readFile(){
        try {
            Scanner fileScanner = new Scanner(getFile());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void writeFile(Scanner in){
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(inputFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("What would you like to write to the file?: ");
        Main.wordArray = in.nextLine().toLowerCase().split(" ");
        String converted = PigLatin.concatWords();
        pw.write(converted);
        pw.close();
    }

    public File getFile(){
        return inputFile;
    }

}
