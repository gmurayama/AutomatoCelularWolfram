package lccm.sippe.controller;

import lccm.sippe.model.Automata;
import lccm.sippe.view.GUIFrame;
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
                int TEST = 10;

                GUIFrame displayWindow = new GUIFrame(60, 60);
                Automata automata = new Automata(60, 60);
                MainController mainController = new MainController(displayWindow, automata);
            }
        });
	}
}
