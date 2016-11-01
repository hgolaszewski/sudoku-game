package Game;

import Starter.SolutionReader;
import java.io.FileNotFoundException;

public class Sudoku {
    
    public int[][] userBoard;
    public int[][] solution;
    private final SolutionReader reader;
    
    public Sudoku() {    
        solution = new int[9][9];
        reader = new SolutionReader();
        solution = reader.loadSolution(solution);
        userBoard = reader.loadCleanedBoard(solution);
    }
}
