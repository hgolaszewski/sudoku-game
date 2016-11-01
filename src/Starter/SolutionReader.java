package Starter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class SolutionReader {
    
    private Random numberGenerator;
    private int solutioNumber;
    private String solutionPath;
    private Shuffler shuffler;
    private Cleaner cleaner;
    
    public SolutionReader() {
        numberGenerator= new Random();
        solutioNumber = numberGenerator.nextInt(15)+1;
        solutionPath = "solutions/s" + solutioNumber +".txt" ;
        shuffler = new Shuffler();
        cleaner = new Cleaner();
    }
    
    public int[][] loadSolution(int[][] solution) {    
        File file = new File(solutionPath);
        Scanner inFile = null;
        String line;
        try {
            inFile = new Scanner(file);            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        int j=0;
        do{
           line = inFile.nextLine();
           for(int i=0; i<9; i++){
               solution[j][i] = (line.charAt(i)-48);
           }
           j++;              
        } while(inFile.hasNext()); 
        inFile.close();
        return shuffler.shuffle(solution); 
    }      
    
    public int[][] loadCleanedBoard(int[][] solution){
        return cleaner.cleanCells(solution);
    }
}
  

