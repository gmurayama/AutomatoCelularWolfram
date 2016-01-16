package lccm.sippe.controller;

import lccm.sippe.model.Automata;
import lccm.sippe.view.GUIFrame;

import javax.swing.*;

public class GameOfLife {
	public static void main(String[] arg) {

		/*
		Automata goL;// The cellular automata object
		/*int lDim = Integer.parseInt(arg[0]);			// Get and convert values from the console
		int cDim=Integer.parseInt(arg[1]);
		int iter=Integer.parseInt(arg[2]);

		goL = new Automata(10,10);
		goL.init();										// Initial situation
		goL.display();
		for (int i=0;i<10;i++) {						// Evolutions loop
			goL.evolve();
			System.out.println();
			System.out.println("=== Generation " + (i+1) + " ===");
			System.out.println();
			goL.display();
		}
		*/

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GUIFrame displayWindow = new GUIFrame();
            }
        });
	}
}
