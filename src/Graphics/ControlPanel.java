package Graphics;

import Game.Clock;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ControlPanel extends JPanel {
    
    private JButton check;
    private JButton newGame;
    private JLabel time;
    private JButton author;
    private Window window;
    private Clock clock; 
    
    public ControlPanel(Window window) {
        this.window = window;
        setConfiguration();
        addCheckButton();
        addNewGameButton();
        addAuthorButton();  
    }
    
    private void addCheckButton() {
        check = new JButton("SPRAWDŹ");
        check.setEnabled(false);
        check.setFocusPainted(false);
        check.setBounds(50, 270, 100, 50);
        check.setBackground(Color.LIGHT_GRAY);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkGame(window)) {
                    clock.timer.cancel();
                    JOptionPane pane = new JOptionPane(
                        "GRATULACJE! WYPEŁNIŁEŚ DIAGRAM POPRAWANIE!"
                        + "\nTWÓJ " + time.getText());
                    JDialog d = pane.createDialog(null, "BRAWO!");
                    d.setLocation(window.getX() + 150, window.getY() + 200);
                    d.setVisible(true);
                } else {
                    clock.nSeconds += 4000;
                }
            }
        });
        add(check);
    }

    private void addNewGameButton() {
        newGame = new JButton("NOWA GRA");
        newGame.setBounds(50, 200, 100, 50);
        newGame.setBackground(Color.LIGHT_GRAY);
        newGame.setFocusPainted(false);
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    window.generateNewGame();
                    check.setEnabled(true);
                    addTimeLabel();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ControlPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        clock = new Clock(time);
                    }
                });
            }
        });
        add(newGame);
    }

    private void addAuthorButton() {
        author = new JButton("O AUTORZE");
        author.setBounds(50, 340, 100, 50);
        author.setBackground(Color.LIGHT_GRAY);
        author.setFocusPainted(false);
        author.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane pane = new JOptionPane(
                    "Super Sudoku "
                    + "\nHubert Gołaszewski © 2016 "
                    + "\nWojskowa Akademia Techniczna ");
                JDialog d = pane.createDialog(null, "O Autorze");
                d.setLocation(window.getX() + 150, window.getY() + 200);
                d.setVisible(true);
            }
       
        });       
        add(author);
    }

    private void addTimeLabel(){
        time = new JLabel();
        time.setFont(new Font("Calibri", Font.BOLD, 25));
        time.setText("");
        time.setBounds(40, 100, 200, 30);
        time.setForeground(new Color(255, 153, 51));
        add(time);
    }

    private boolean checkGame(Window window){
        boolean isCorrect = true; 
        int[][] board = window.sudokuGame.solution;
            LinkedList<Cell> cells = window.sudokuPanel.cells;
            int k = 0;
            Color wrongColor = new Color(255, 77, 77);
            Color goodColor = Color.LIGHT_GRAY;
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    try{
                        if(board[i][j] != Integer.parseInt(cells.get(k).field.getText())) {
                            isCorrect = false;
                            cells.get(k).setBackground(wrongColor);
                        }
                        else{
                            if(cells.get(k).getBackground() != goodColor) 
                                cells.get(k).setBackground(goodColor);
                        }
                    }
                    catch(NumberFormatException ex){
                        isCorrect = false;
                        cells.get(k).setBackground(new Color(255, 77, 77));
                    }
                    k++;
                }
            }
        return isCorrect;  
    }
    
    public void setConfiguration(){
        setLayout(null);
        setBounds(500, 0, 200, 530);
        setPreferredSize(new Dimension(180, 530));
        setBackground(Color.DARK_GRAY);
        setOpaque(true);  
    }
}
