package Starter;

import Game.Level;
import java.util.Arrays;
import java.util.Random;

public class Cleaner {

    private final int emptyCells;

    public Cleaner(Level levelType) {
        if (levelType == Level.EAZY) {
            emptyCells = 0x19;
        } else if (levelType == Level.MEDIUM) {
            emptyCells = 0x2d;
        } else {
            emptyCells = 0x3e;
        }
    }

    public int[][] cleanCells(int[][] solutionBoard) {
        int[][] newBoard = new int[9][9];
        for (int i = 0; i < 9; i++) {
            newBoard[i] = Arrays.copyOf(solutionBoard[i], 9);
        }
        Random generator = new Random();
        int row, column;
        for (int i = 0; i < emptyCells;) {
            row = generator.nextInt(9);
            column = generator.nextInt(9);
            if (newBoard[row][column] != 0) {
                newBoard[row][column] = 0;
                i++;
            }
        }
        return newBoard;
    }
}
