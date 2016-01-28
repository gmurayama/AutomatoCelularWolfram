package lccm.sippe;

import lccm.sippe.controller.MainController;

import javax.swing.*;

/**
 * @author: Luis Carlos Castillo Martinez on 18/01/16.
 * Université Blaise Pascal
 * lcarlos.asimov@gmail.com
 * github.com/luisccastillo
 */

public class GameOfLife {
	public static void main(String[] arg) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainController mainController = new MainController();
            }
        });
	}
}
