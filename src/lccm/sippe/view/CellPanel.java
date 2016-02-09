package lccm.sippe.view;

import lccm.sippe.model.GamePreferences;

import javax.swing.*;
import java.awt.Color;


/**
 * @author: Luis Carlos Castillo Martinez on 18/01/16.
 * Université Blaise Pascal
 * lcarlos.asimov@gmail.com
 * github.com/luisccastillo
 */
public class CellPanel extends JPanel{

    private boolean isAlive;
    private final Color deadCellColor = GamePreferences.getDeadCellColor();
    private final Color aliveCellColor = GamePreferences.getAliveCellColor();

    public CellPanel(){
        initialize();
    }

    private void initialize(){
        if (GamePreferences.isBorderedGrid())
            this.setBorder(BorderFactory.createLineBorder(GamePreferences.getBorderColor()));
    }

    public void setAlive(){
        this.setBackground(aliveCellColor);
        this.isAlive = true;
    }

    public void setDead(){
        this.setBackground(deadCellColor);
        this.isAlive = false;
    }

    public boolean isAlive(){
        return isAlive;
    }


}
