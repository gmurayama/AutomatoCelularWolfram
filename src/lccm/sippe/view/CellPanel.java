package lccm.sippe.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 * Created by duder on 16/01/16.
 */
public class CellPanel extends JPanel {

    public CellPanel(){
        initialize();
    }

    public void initialize(){
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBackground(Color.green);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setBackground(Color.red);
            }
        });
    }


}
