package lccm.sippe.controller;

import lccm.sippe.model.GamePreferences;
import lccm.sippe.view.CellPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author: Luis Carlos Castillo Martinez on 18/01/16.
 * Université Blaise Pascal
 * lcarlos.asimov@gmail.com
 * github.com/luisccastillo
 */
public class CellPanelGridController extends JPanel{

    private final int xCellCount;
    private final int yCellCount;
    private boolean[][] automataReference;
    private final Color aliveCellColor = GamePreferences.getAliveCellColor();
    private final Color deadCellColor = GamePreferences.getDeadCellColor();
    private final Color cellPointerColor = GamePreferences.getCellPointerColor();

    public CellPanelGridController(int xCellCount, int yCellCount){
        this.xCellCount = xCellCount;
        this.yCellCount = yCellCount;
        automataReference = new boolean[xCellCount][yCellCount];
        initialize();
        fillCellPanelGrid();
    }

    private void initialize(){
        this.setBackground(Color.gray);
        this.setLayout(new GridLayout(xCellCount, yCellCount));
        addCellPanels();
    }

    /** Creates CellPanel objects and adds them to the UI Panel
    *  at a 1D position
    */
    private void addCellPanels(){
        CellPanel cellPanel;
        for (int i = 0; i < xCellCount * yCellCount; i++){
            int row = i / xCellCount;
            int col = i % yCellCount;
            cellPanel = createCellPanel(row, col);
            this.add(cellPanel);
        }
    }

    /** Creates a CellPanel object at a 2D position,
    *  adds the MouseListener event handler for the MouseClicked event in each CellPanel
    *
    *  @param row int the row number where the CellPanel will be located
    *  @param col int the col number where the CellPanel will be located
    *  @return CellPanel the created CellPanel object
    */
    private CellPanel createCellPanel(final int row, final int col) {
        final CellPanel cellPanel = new CellPanel();
        cellPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {}

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                modifyCellPanelAtPosition(row, col);
                modifyAutomataAtPosition(row, col);
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {}

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
                paintMouseEnteredCell(row, col);
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                paintMouseExitedCell(row, col);
            }
        });
        return cellPanel;
    }


    private void paintMouseEnteredCell(int row, int col) {
        CellPanel cellPanel = getCellPanelAtPosition(row, col);
        cellPanel.setBackground(cellPointerColor);
    }

    private void paintMouseExitedCell(int row, int col){
        CellPanel cellPanel = getCellPanelAtPosition(row, col);
        if (cellPanel.isAlive())
            cellPanel.setBackground(aliveCellColor);
        else
            cellPanel.setBackground(deadCellColor);
    }

    /** Modifies the value of the CellPanel at a given position
    *
    *  @param row int the row number where the cell is located
    *  @param col int the col number where the cell is located
    */
    private void modifyCellPanelAtPosition(int row, int col){
        CellPanel cellPanel = getCellPanelAtPosition(row, col);
        if (cellPanel.isAlive())
            cellPanel.setDead();
        else
            cellPanel.setAlive();
    }

    /** Modifies the value of the Automata array copy at a given position
     *
     * @param row int the row number where the cell is located
     * @param col int the col number where the cell is located
     */
    private void modifyAutomataAtPosition(int row, int col) {
        if (automataReference[row][col])
            automataReference[row][col] = false;
        else
            automataReference[row][col] = true;
    }

    /** Iterates over the Automata array copy,
     * finds the row, col coordinates of a CellPanel
     * changes the state of the CellPanel
     */
    public void fillCellPanelGrid(){
        CellPanel cellPanel;
        for (int i = 0; i < automataReference.length; i++) {
            for (int j = 0; j < automataReference[0].length; j++) {
                cellPanel = getCellPanelAtPosition(i,j);
                if (automataReference[i][j])
                    cellPanel.setAlive();
                else
                    cellPanel.setDead();
            }
        }
    }

    /** Returns a CellPanel object at the specified 2D coordinates
     *
     * @param row int the row number where the cell is located
     * @param col int the col number where the cell is located
     * @return CellPanel the CellPanel found at the row, col position
     */
    private CellPanel getCellPanelAtPosition(int row, int col){
        int index = row * xCellCount + col;
        return (CellPanel)getComponent(index);
    }

    /**
     * Iterates over the CellPanelGrid and changes the state of each
     * CellPanel to dead
     */
    public void emptyGrid(){
        for (int i = 0; i < xCellCount * yCellCount; i++) {
            CellPanel cellPanel = (CellPanel) this.getComponent(i);
            cellPanel.setDead();
        }
    }

    public boolean[][] getAutomataReference() {
        return automataReference;
    }

    public void setAutomataReference(boolean[][] automataReference) {
        this.automataReference = automataReference;
    }

}
