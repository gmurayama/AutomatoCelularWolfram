package lccm.sippe.view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.geom.Line2D;

/**
 * Created by duder on 15/01/16.
 */
public class CellGridPanel extends JPanel{

    private int xSize;
    private int ySize;

    public CellGridPanel(int xsize, int ysize){
        this.xSize = xsize;
        this.ySize = ysize;
        initialize();
    }

    public void initialize(){
        this.setBackground(Color.gray);
        this.setLayout(new GridLayout(xSize, ySize));
        for (int i=0; i < xSize * ySize; i++){
            this.add(new CellPanel());
        }

    }

}
