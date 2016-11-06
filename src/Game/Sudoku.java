package Game;

import Starter.SolutionReader;
import java.io.FileNotFoundException;

public class Sudoku {

    private final int[][] userBoard;
    private int[][] solution;
    private final SolutionReader reader;

    public Sudoku(Level levelType) throws FileNotFoundException {
        solution = new int[9][9];
        reader = new SolutionReader(levelType);
        solution = reader.loadSolution(solution);
        userBoard = reader.loadCleanedBoard(solution);
    }

    public int[][] getUserBoard() {
        return userBoard;
    }

    public int[][] getSolution() {
        return solution;
    }
}
