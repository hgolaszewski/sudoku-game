package Starter;

import Game.Level;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class SolutionReader {

    private final Random numberGenerator;
    private final int solutioNumber;
    private final String solutionPath;
    private final Shuffler shuffler;
    private final Cleaner cleaner;

    public SolutionReader(Level levelType) {
        numberGenerator = new Random();
        solutioNumber = numberGenerator.nextInt(15) + 1;
        solutionPath = "solutions/s" + solutioNumber + ".txt";
        shuffler = new Shuffler();
        cleaner = new Cleaner(levelType);
    }

    public int[][] loadSolution(int[][] solution) throws FileNotFoundException {
        File file = new File(solutionPath);
        Scanner inFile = null;
        String line = "";
        inFile = new Scanner(file);
        int j = 0;
        do {
            line = inFile.nextLine();
            for (int i = 0; i < 9; i++) {
                solution[j][i] = (line.charAt(i) - 48);
            }
            j++;
        } while (inFile.hasNext());
        inFile.close();
        return shuffler.shuffle(solution);
    }

    public int[][] loadCleanedBoard(int[][] solution) {
        return cleaner.cleanCells(solution);
    }
}
