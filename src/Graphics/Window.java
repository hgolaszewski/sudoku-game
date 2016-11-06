package Graphics;

import Game.Level;
import Game.Sudoku;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Window extends JFrame {

    private SudokuPanel sudokuPanel;
    private final ControlPanel controlPanel;
    private Sudoku sudokuGame;

    public Window(String title) {
        super(title);
        loadConfiguration();
        controlPanel = new ControlPanel(this);
        add(controlPanel);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Window("Super Sudoku");
    }

    public void generateNewGame(Level levelType) throws FileNotFoundException {
        if (sudokuPanel != null) {
            remove(sudokuPanel);
        }
        sudokuGame = new Sudoku(levelType);
        addGamePanel();
        revalidate();
        repaint();
    }

    private void loadConfiguration() {
        setLayout(null);
        setPreferredSize(new Dimension(700, 530));
        setLocation(new Point(200, 200));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(128, 128, 128));
        setIconImage(Toolkit.getDefaultToolkit().getImage("Icon/icon.png"));
        JLabel background = new JLabel(new ImageIcon("background/sudoku.png"));
        background.setBackground(Color.DARK_GRAY);
        background.setOpaque(true);
        setContentPane(background);
    }

    private void addGamePanel() {
        sudokuPanel = new SudokuPanel(sudokuGame);
        add(sudokuPanel);
    }

    public Sudoku getSudokuGame() {
        return sudokuGame;
    }

    public SudokuPanel getSudokuPanel() {
        return sudokuPanel;
    }
}
