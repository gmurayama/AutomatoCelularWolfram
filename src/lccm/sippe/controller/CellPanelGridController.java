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

    private int xCellCount;
    private int yCellCount;
    private int[][] automataCopy;

    public CellPanelGridController(int xCellCount, int yCellCount){
        this.xCellCount = xCellCount;
        this.yCellCount = yCellCount;
        automataCopy = new int[xCellCount][yCellCount];
        initialize();
        fillCellPanelGrid();
    }

    public void initialize(){
        this.setBackground(Color.gray);
        this.setLayout(new GridLayout(xCellCount, yCellCount));
        addCellPanels();
    }

    /* Creates CellPanel objects and adds them to the UI Panel
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

    /* Creates a CellPanel object at a 2D position,
    *  adds the MouseListener event handler for the MouseClicked event in each CellPanel
    *
    *  @param int row the row number where the CellPanel will be located
    *  @param int col the col number where the CellPanel will be located
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
        cellPanel.setHooverColor();
    }

    private void paintMouseExitedCell(int row, int col){
        CellPanel cellPanel = getCellPanelAtPosition(row, col);
        if (cellPanel.isAlive())
            cellPanel.setBackground(GamePreferences.getAliveCellColor());
        else
            cellPanel.setBackground(GamePreferences.getDeadCellColor());
    }

    /* Modifies the value of the CellPanel at a given position
    *
    *  @param int row the row number where the cell is located
    *  @param int col the col number where the cell is located
    */
    private void modifyCellPanelAtPosition(int row, int col){
        CellPanel cellPanel = getCellPanelAtPosition(row, col);
        if (cellPanel.isAlive())
            cellPanel.setDead();
        else
            cellPanel.setAlive();
    }

    /* Modifies the value of the Automata array copy at a given position
     *
     * @param int row the row number where the cell is located
     * @param int col the col number where the cell is located
     */
    private void modifyAutomataAtPosition(int row, int col) {
        if (automataCopy[row][col] == 1)
            automataCopy[row][col] = 0;
        else
            automataCopy[row][col] = 1;
    }

    /* Iterates over the Automata array copy,
     * finds the row, col coordinates of a CellPanel
     * changes the state of the CellPanel
     */
    public void fillCellPanelGrid(){
        CellPanel cellPanel;
        for (int i = 0; i < automataCopy.length; i++) {
            for (int j = 0; j < automataCopy[0].length; j++) {
                cellPanel = getCellPanelAtPosition(i,j);
                if (automataCopy[i][j] == 1)
                    cellPanel.setAlive();
                else
                    cellPanel.setDead();
            }
        }
    }

    /* Returns a CellPanel object at the specified 2D coordinates
     *
     * @param int row the row number where the cell is located
     * @param int col the col number where the cell is located
     * @return CellPanel the CellPanel found at the row, col position
     */
    public CellPanel getCellPanelAtPosition(int row, int col){
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

    public int[][] getAutomataCopy() {
        return automataCopy;
    }

    public void setAutomataCopy(int[][] automataCopy) {
        this.automataCopy = automataCopy;
    }

}

/*


 */