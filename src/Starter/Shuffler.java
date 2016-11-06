package Starter;

import java.util.Random;

public class Shuffler {

    private final Random generator;
    private final boolean horizontalSwap;
    private final boolean verticalSwap;

    public Shuffler() {
        generator = new Random();
        horizontalSwap = generator.nextBoolean();
        verticalSwap = generator.nextBoolean();
    }

    public int[][] shuffle(int[][] solutionBoard) {
        if (horizontalSwap) {
            solutionBoard = horizontalSwap(solutionBoard);
        }
        if (verticalSwap) {
            solutionBoard = verticalSwap(solutionBoard);
        }
        return solutionBoard;
    }

    private int[][] horizontalSwap(int[][] solutionBoard) {
        int[][] newBoard = new int[9][9];
        int k = 8;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                newBoard[k][j] = solutionBoard[i][j];
            }
            k--;
        }
        return newBoard;
    }

    private int[][] verticalSwap(int[][] solutionBoard) {
        int[][] newBoard = new int[9][9];
        int k = 8;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                newBoard[j][k] = solutionBoard[j][i];
            }
            k--;
        }
        return newBoard;
    }
}
