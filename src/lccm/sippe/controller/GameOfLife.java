package lccm.sippe.controller;

import lccm.sippe.model.Automata;
import lccm.sippe.view.GUIFrame;

import javax.swing.*;

public class GameOfLife {
	public static void main(String[] arg) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                int TEST = 10;

                GUIFrame displayWindow = new GUIFrame(TEST,TEST);
                Automata automata = new Automata(TEST,TEST);
                MainController mainController = new MainController(displayWindow, automata);
            }
        });
	}
}
