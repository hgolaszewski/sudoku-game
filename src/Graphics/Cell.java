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

public class Cell extends JLabel {

    private final JTextField cellValue;

    public Cell(int row, int column, Sudoku sudokuGame) {
        cellValue = new JTextField();
        loadConfiguration();
        addTextFiled(sudokuGame, row, column);
    }

    private void loadConfiguration() {
        setMinimumSize(new Dimension(50, 50));
        setPreferredSize(new Dimension(50, 50));
        setMaximumSize(new Dimension(50, 50));
        setBackground(Color.LIGHT_GRAY);
        setOpaque(true);
    }

    public void addTextFiled(Sudoku sudokuGame, int row, int column) {
        cellValue.setBounds(10, 10, 30, 30);
        cellValue.setBackground(Color.LIGHT_GRAY);
        cellValue.setOpaque(true);
        cellValue.setFont(new Font("Calibri", Font.BOLD, 28));
        cellValue.setBorder(null);
        cellValue.setHorizontalAlignment(SwingConstants.CENTER);
        if (sudokuGame.getUserBoard()[row][column] != 0) {
            cellValue.setText(Integer.toString(sudokuGame.getUserBoard()[row][column]));
            cellValue.setForeground(new Color(0, 152, 14));
            cellValue.setFocusable(false);
        } else {
            cellValue.setText("");
            addTextFieldFilter();
        }
        add(cellValue);
    }

    private void addTextFieldFilter() {
        AbstractDocument abstractDocument = (AbstractDocument) cellValue.getDocument();
        abstractDocument.setDocumentFilter(new DocumentFilter() {
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
                if (documentLength - length + text.length() <= 1 && isValidInteger) {
                    super.replace(filter, offset, length, text, attrs);
                }
            }
        });
    }

    public JTextField getCellValue() {
        return cellValue;
    }
}
