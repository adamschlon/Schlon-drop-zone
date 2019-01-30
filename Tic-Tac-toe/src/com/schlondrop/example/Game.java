package com.schlondrop.example;
import java.util.Scanner;

public class Game {

    static boolean s = true; //true is running
    public static int currentPlayer = 1;
    static Scanner scnr = new Scanner(System.in);
    @SuppressWarnings("unused")
    
    
    
    public static void main(String[] args) {
        Board myBoard = new Board();
        System.out.println("Player 1 is X\nPlayer 2 is O\n");
        
        
        while(true) {   //main loop
            
            String[] b = myBoard.getBoard();
            Prompt(b);
            System.out.print(myBoard);
            int playerChoice = scnr.nextInt();
            Selection(playerChoice, myBoard);
            if(IsGameOver(b)) {
                System.out.println(myBoard);
                break;
            }
        }
    }


    
public static void Prompt(String[] x) {
    System.out.println("Player" + currentPlayer + "\'s turn!");
    System.out.println("Select Cell 0 - 8");
}    

    
public static void Selection(int pC, Board mB) {
    if(mB.getBoard()[pC] == "-") {
        if(currentPlayer == 1) {
            mB.getBoard()[pC] = "X";
            currentPlayer += 1;
        }
        else if (currentPlayer == 2) {  
            mB.getBoard()[pC] = "O";
            currentPlayer -= 1;
        }
        else {
            System.out.println("Player status error");
        }
    }
    else {
        System.out.println("Space already selected");
    }
}
    
    
    
    
    
private static boolean IsGameOver(String[] x) {
    s = gStat(x);
    if (!s) {
        if (currentPlayer == 1) {
            System.out.println("Player 2 wins!");
        }
        else {
            System.out.println("Player 1 wins!");
        }
        return true;
    }
    else {
        return false;
    }
}
    
    
    
private static boolean gStat(String[] x) {
    
        boolean gameStatus = true;
        
        if (x[0] != "-" && x[0] == x[1] && x[1] == x[2]) {
            gameStatus = false;
        }
        else if (x[3] != "-" && x[3] == x[4] && x[4] == x[5]) {
            gameStatus = false;
        }
        else if (x[6] != "-" && x[6] == x[7] && x[7] == x[8]) {
            gameStatus = false;
        }
        else if (x[0] != "-" && x[0] == x[3] && x[3] == x[6]) {
            gameStatus = false;
        }
        else if (x[1] != "-" && x[1] == x[4] && x[4] == x[7]) {
            gameStatus = false;
        }
        else if (x[2] != "-" && x[2] == x[5] && x[5] == x[8]) {
            gameStatus = false;
        }
        else if (x[0] != "-" && x[0] == x[4] && x[4] == x[8]) {
            gameStatus = false;
        }
        else if (x[2] != "-" && x[2] == x[4] && x[4] == x[6]) {
            gameStatus = false;
        }
        
        return gameStatus;
    }
}
