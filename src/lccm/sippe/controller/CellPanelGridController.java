package lccm.sippe.controller;

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
 *
 * Errores: modificacion de la formula para trabajar con x,y desiguales
 *
 *
 */
public class CellPanelGridController extends JPanel{

    private int xCellCount;
    private int yCellCount;
    private int[][] automataCopy;

    public CellPanelGridController(int xCellCount, int yCellCount){
        this.xCellCount = xCellCount;
        this.yCellCount = yCellCount;
        initialize();
    }

    private void initialize(){
        this.setBackground(Color.gray);
        this.setLayout(new GridLayout(xCellCount, yCellCount));
        addCellPanels();
    }

    private void addCellPanels(){
        CellPanel cellPanel;
        for (int i = 0; i < xCellCount * yCellCount; i++){
            int row = i / xCellCount;
            int col = i % yCellCount;
            cellPanel = createCellPanel(row, col);
            this.add(cellPanel);
        }
    }

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
            public void mouseEntered(MouseEvent mouseEvent) {}

            @Override
            public void mouseExited(MouseEvent mouseEvent) {}
        });
        return cellPanel;
    }

    private void modifyCellPanelAtPosition(int row, int col){
        CellPanel cellPanel = getCellPanelAtPosition(row, col);
        if (cellPanel.isAlive() == true)
            cellPanel.setDead();
        else
            cellPanel.setAlive();
    }

    private void modifyAutomataAtPosition(int row, int col) {
        if (automataCopy[row][col] == 1)
            automataCopy[row][col] = 0;
        else
            automataCopy[row][col] = 1;
    }

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

    public CellPanel getCellPanelAtPosition(int row, int col){
        int index = row * xCellCount + col;
        //int index = row * automataCopy[0].length + col;
        return (CellPanel)getComponent(index);
    }

    public void emptyGrid(){
        for (int i = 0; i < xCellCount * yCellCount; i++){
            CellPanel cellPanel = (CellPanel)this.getComponent(i);
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
