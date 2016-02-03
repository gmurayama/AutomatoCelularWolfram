package lccm.sippe.view;

import lccm.sippe.model.GamePreferences;

import javax.swing.*;


/**
 * @author: Luis Carlos Castillo Martinez on 18/01/16.
 * Université Blaise Pascal
 * lcarlos.asimov@gmail.com
 * github.com/luisccastillo
 */
public class CellPanel extends JPanel{

    private boolean isAlive;

    public CellPanel(){
        initialize();
    }

    private void initialize(){
        if (GamePreferences.isBorderedGrid())
            this.setBorder(BorderFactory.createLineBorder(GamePreferences.getBorderColor()));
    }

    public void setAlive(){
        this.setBackground(GamePreferences.getAliveCellColor());
        this.isAlive = true;
    }

    public void setDead(){
        this.setBackground(GamePreferences.getDeadCellColor());
        this.isAlive = false;
    }

    public boolean isAlive(){
        return isAlive;
    }


}
