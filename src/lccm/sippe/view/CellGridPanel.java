package lccm.sippe.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

/**
 * @author: Luis Carlos Castillo Martinez on 18/01/16.
 * Université Blaise Pascal
 * lcarlos.asimov@gmail.com
 * github.com/luisccastillo
 *
 * Errores: modificacion de la formula para trabajar con x,y desiguales
 * Lograr mandar posicion, y objetos al controlador principal
 *
 */
public class CellGridPanel extends JPanel{

    private int xCellCount;
    private int yCellCount;
    private int N;
    private final ArrayList<CellPanel> list = new ArrayList<CellPanel>();

    public CellGridPanel(int xCellCount, int yCellCount){
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
            //this.list.add(cellPanel);
            this.add(cellPanel);
        }

    }

    private CellPanel createCellPanel(final int row, final int col) {
        final CellPanel cp = new CellPanel();
        cp.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {

            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                CellPanel gb = CellGridPanel.this.getCellXYPosition(row, col);
                gb.setBackground(Color.green);
                System.out.println("r" + row + ",c" + col);
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });
        return cp;
    }


    public CellPanel getCell(int position){
        return (CellPanel)getComponent(position);
    }

    public CellPanel getCellXYPosition(int xPosition, int yPosition){
        int index = xPosition * N + yPosition;
        return (CellPanel)getComponent(index);
    }

}
