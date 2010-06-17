package com.crosswordmaster.brain;

import java.util.Random;

public class Brain {

    public static char[][] getCrossword(int x, int y) {

        char[][] cw = new char[x][y];

        Random rnd = new Random();
        
        for (int i = 0; i < cw.length; i++) {
            for (int j = 0; j < cw[i].length; j++) {
                cw[i][j] = (char) (rnd.nextInt(25) + 97);
            }
        }

        return cw;
    }

    public static void main(String[] args) {

        System.out.println("Brain is alive.");
        
        char[][] cw = getCrossword(15,15);
        
        for (int i = 0; i < cw.length; i++) {
            for (int j = 0; j < cw[i].length; j++) {
                System.out.print(cw[i][j]);
            }
            System.out.println();
        }

    }

}
