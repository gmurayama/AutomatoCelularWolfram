package lccm.sippe.view;

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
public class CellGridPanelController extends JPanel{

    private int xCellCount;
    private int yCellCount;
    private int N;
    private int[][] grid;
    private boolean isStopped;

    public CellGridPanelController(int xCellCount, int yCellCount){
        this.xCellCount = xCellCount;
        this.yCellCount = yCellCount;
        initialize();
    }

    public void initialize(){
        this.setBackground(Color.gray);
        this.setLayout(new GridLayout(xCellCount, yCellCount));
        CellPanel cellPanel;
        N  = xCellCount;

        for (int i = 0; i < xCellCount * yCellCount; i++){
            int row = i / xCellCount;
            int col = i % yCellCount;
            cellPanel = createCellPanel(row, col);
            this.add(cellPanel);
        }

    }


    /*
    Crear una copia del arrelgo para despues pasarla y modificar el valor en elarrelgo principal
    cambiar el valor del elemento de uno a zero,
    activar o desactivar el elemento del panel para cambiar su color y modificar su valo r
    actualizar el conttrolador pasando como parametro el arrelgo modificado.

    /
     */
    private int[][] modifyGridAtPosition(int xPosition, int yPosition) {
        int[][] gridCopy= grid;
        if (gridCopy[xPosition][yPosition] == 1){
            gridCopy[xPosition][yPosition] = 0;
        }
        else{
            gridCopy[xPosition][yPosition] = 1;
        }
        return gridCopy;
    }

    private CellPanel createCellPanel(final int row, final int col) {
        final CellPanel cp = new CellPanel();
        cp.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {}

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                CellPanel gb = CellGridPanelController.this.getCellAtXYPosition(row, col);
                CellGridPanelController.this.grid = modifyGridAtPosition(row,col);
                if (gb.isAlive() == true){
                    gb.setDead();
                }
                else{
                    gb.setAlive();
                }
                //System.out.println("r" + row + ",c" + col);
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {}

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {}

            @Override
            public void mouseExited(MouseEvent mouseEvent) {}
        });
        return cp;
    }


    public void fillCellGrid(int grid[][]){
        this.grid = grid;
        CellPanel cellPanel;
        // int linearCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j<grid[0].length;  j++) {
                cellPanel = this.getCellAtXYPosition(i,j);
                //cellPanel = cellGridPanelController.getCell(linearCount);
                if (grid[i][j] == 1)
                    cellPanel.setAlive();
                else
                    cellPanel.setDead();
                //linearCount++;
            }
        }
    }


    public CellPanel getCell(int position){
        return (CellPanel)getComponent(position);
    }

    public CellPanel getCellAtXYPosition(int xPosition, int yPosition){
        int index = xPosition * N + yPosition;
        return (CellPanel)getComponent(index);
    }

    public int[][] getGrid() {
        return grid;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }

    public boolean setIsStopped(boolean a){
        return true;
    }

}
