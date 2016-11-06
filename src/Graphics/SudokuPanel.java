package Graphics;

import Game.Sudoku;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedList;
import javax.swing.JPanel;

public class SudokuPanel extends JPanel {

    private LinkedList<Cell> boardCells;

    public SudokuPanel(Sudoku sudokuGame) {
        boardCells = new LinkedList<Cell>();
        loadConfiguration();
        drawCells(sudokuGame);
    }

    private void drawCells(Sudoku sudokuGame) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Cell cell = new Cell(i, j, sudokuGame);
                boardCells.add(cell);
                this.add(cell);
            }
        }
    }

    private void loadConfiguration() {
        setBounds(0, 0, 500, 600);
        setPreferredSize(new Dimension(800, 600));
        setBackground(new Color(128, 128, 128));
        setOpaque(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(5));
        g2.drawLine(167, 0, 167, 500);
        g2.drawLine(332, 0, 332, 500);
        g2.drawLine(2, 0, 2, 500);
        g2.drawLine(497, 0, 497, 500);
        g2.drawLine(2, 2, 507, 2);
        g2.drawLine(2, 167, 507, 167);
        g2.drawLine(2, 332, 507, 332);
        g2.drawLine(2, 498, 507, 498);
    }

    public LinkedList<Cell> getBoardCells() {
        return boardCells;
    }
}
