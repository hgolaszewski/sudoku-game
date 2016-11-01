package Graphics;

import Game.Sudoku;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class Cell extends JLabel{
    
    public JTextField field;
    
    public Cell(int row, int column, Sudoku sudokuGame ){

        field = new JTextField(); 
        loadConfiguration();
        addTextFiled(sudokuGame, row, column);

    }
    
    private void loadConfiguration(){
        setMinimumSize(new Dimension(50,50));
        setPreferredSize(new Dimension(50,50));
        setMaximumSize(new Dimension(50,50));
        setBackground(Color.LIGHT_GRAY);
        setOpaque(true);
        setLocation(20, 20);
    }
    
    public void addTextFiled(Sudoku sudokuGame, int row, int column){
        field.setBounds(10, 10, 30, 30);
        field.setBackground(Color.LIGHT_GRAY);
        field.setOpaque(true);
        field.setFont(new Font("Calibri", Font.BOLD, 28));
        field.setBorder(null);
        field.setHorizontalAlignment(SwingConstants.CENTER);
        field.setText((sudokuGame.userBoard[row][column] != 0 ? Integer.toString(sudokuGame.userBoard[row][column]) : ""));
        if (sudokuGame.userBoard[row][column] != 0) {
            field.setForeground(new Color(0, 152, 14));
            field.setFocusable(false);
        } else {
            AbstractDocument abstractDocument = (AbstractDocument)field.getDocument();
            abstractDocument.setDocumentFilter(new DocumentFilter() { 
                int maxLength = 1;
                @Override
                public void replace(DocumentFilter.FilterBypass filter, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                    int documentLength = filter.getDocument().getLength();
                    int textLength = text.length();
                    boolean isValidInteger = true; 
                    for (int i = 0; i < textLength; i++) {
                        if (!Character.isDigit(text.charAt(i)) || text.charAt(i) == '0') {
                            isValidInteger = false;
                            break;
                        }
                    }
                    if (documentLength - length + text.length() <= maxLength && isValidInteger) 
                        super.replace(filter, offset, length, text, attrs);
                }
            });
        }
        add(field);  
    }
}
