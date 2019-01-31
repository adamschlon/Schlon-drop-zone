package com.schlondrop.tictactoe;

public class Board {
    String[] board;
    public Board() {
        board = new String[] {
            "-","-","-","-","-","-","-","-","-"
        };
    }
    
    public String[] getBoard() {
        return board;
    }
    
    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                str += this.board[3 * i + j];
            }
            str += "\n";
        }
        return str;
    }
}
