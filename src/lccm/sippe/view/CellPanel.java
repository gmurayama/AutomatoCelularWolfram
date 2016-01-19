package lccm.sippe.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author: Luis Carlos Castillo Martinez on 18/01/16.
 * Université Blaise Pascal
 * lcarlos.asimov@gmail.com
 * github.com/luisccastillo
 */
public class CellPanel extends JPanel{

    public CellPanel(){
        initialize();
    }

    public void initialize(){
        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public void setAlive(){
        this.setBackground(Color.lightGray);
    }

    public void setDead(){
        this.setBackground(Color.DARK_GRAY);
    }



}
