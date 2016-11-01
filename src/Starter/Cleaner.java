package Starter;

import java.util.Arrays;
import java.util.Random;

public class Cleaner {
    
    private final int emptyCells;
    
    public Cleaner(){
        emptyCells = 0x32;
    }
    
    public int[][] cleanCells(int[][] solutionBoard){ 
        int[][] newBoard = new int[9][9];
        for(int i=0; i<9; i++){
            newBoard[i] = Arrays.copyOf(solutionBoard[i], 9);
        }
        Random generator = new Random();
        int row, column;
        for(int i = 0; i < emptyCells; ){
            row = generator.nextInt(9);
            column = generator.nextInt(9);
            if(newBoard[row][column] != 0){
                newBoard[row][column] = 0;
                i++;
            }
        }
        return newBoard;
    }
}
