package com.schlondrop.battleship;

import javax.swing.*;

public class Swing {

    public static void newBoard(String player, int size){
        JFrame f = new JFrame(player);
        GroupLayout groupLayout = new GroupLayout(f);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        for(int x = 0; x < 11; x++) {
            for(int y = 0; y < 11; y++){
                if(y == 0) {
                    JButton b = new JButton("" + x + "-" + y);
                    b.setSize(100,100);
                    f.add(b);
                }
            }
        }
        f.setSize(1000,1000);
        f.setLayout(groupLayout);
        f.setVisible(true);


//        for(int i = 0; i < 11; i++) {
//            f.add(new JButton());
//        }
    }
}
