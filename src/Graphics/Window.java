package Graphics;

import Game.Sudoku;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Window extends JFrame {
    
    public SudokuPanel sudokuPanel;
    public ControlPanel controlPanel;
    public Sudoku sudokuGame;
    
    public Window(String title) {
        super(title);
        loadConfiguration();
    }
    
    public static void main(String[] args) {
        new Window("Super Sudoku");
    }
    
    public void generateNewGame() throws FileNotFoundException {
        if (sudokuPanel != null) 
            remove(sudokuPanel);
        sudokuGame = new Sudoku();
        sudokuPanel = new SudokuPanel(sudokuGame);
        add(sudokuPanel);
        revalidate();
        repaint();
    }
    
    private void loadConfiguration() {
        setLayout(null);
        setBounds(200, 200, 700, 530);
        setPreferredSize(new Dimension(700, 530));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(new Color(128, 128, 128));
        setIconImage(Toolkit.getDefaultToolkit().getImage("Icon/icon.png"));
        JLabel background = new JLabel(new ImageIcon("background/sudoku.png"));
        background.setBackground(Color.DARK_GRAY);
        background.setOpaque(true);
        setContentPane(background);
        addControlPanel();       
        pack();
        setVisible(true);
    }
    
    private void addControlPanel() {
        controlPanel = new ControlPanel(this);
        add(controlPanel);
    }
}
