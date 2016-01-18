package lccm.sippe.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author: Luis Carlos Castillo Martinez on 18/01/16.
 * Université Blaise Pascal
 * lcarlos.asimov@gmail.com
 * github.com/luisccastillo
 */
public class CellGridPanel extends JPanel{

    private int xCellCount;
    private int yCellCount;

    public CellGridPanel(int xCellCount, int yCellCount){
        this.xCellCount = xCellCount;
        this.yCellCount = yCellCount;
        initialize();
    }

    public void initialize(){
        this.setBackground(Color.gray);
        this.setLayout(new GridLayout(xCellCount, yCellCount));
        for (int i = 0; i < xCellCount * yCellCount; i++){
            this.add(new CellPanel());
        }
    }

    public CellPanel getCell(int position){
        return (CellPanel)getComponent(position);
    }

    public List getCells(){

        return null;
        //return new ArrayList<CellPanel>(this.getComponents());
    }

}
