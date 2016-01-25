package lccm.sippe.controller;

import lccm.sippe.model.Automata;

import lccm.sippe.view.GUIFrame;
import java.awt.event.*;

/**
 * @author: Luis Carlos Castillo Martinez on 18/01/16.
 * Université Blaise Pascal
 * lcarlos.asimov@gmail.com
 * github.com/luisccastillo
 */

public class MainController {

    private GUIFrame guiFrame;
    private CellPanelGridController cellGridPanelController;
    private Automata automata;
    private boolean isRunning;
    private int speed;

    public MainController(GUIFrame guiFrame, Automata automata){
        this.guiFrame = guiFrame;
        this.automata = automata;
        this.cellGridPanelController = guiFrame.getCellGridPanelController();
        initialize();
    }

    /* MainController initialization tasks:
    *  - intializes the Automata object with empty values
    *  - intializes the isRunning flag to false
    *  - sets the Automata array as a copy to the CellPanelController
    *  - updates the CellPanel grid with its own copy of the Automata array
    *  - starts the Evolution thread
    */
    private void initialize(){
        addGUIEventListeners();
        automata.init();
        isRunning = false;
        speed = 100;
        cellGridPanelController.setAutomataCopy(automata.getGrid());
        cellGridPanelController.fillCellPanelGrid();
        Thread evolutionThread = new Thread(new EvolutionThread());
        evolutionThread.start();
    }

    private class EvolutionThread implements Runnable{

        /* When the isRunning flag is true:
         * - modifies the Automata array by its evolution rules
         * - updates the Automata array copy of the CellGridPanel controller to the Automata array
         * - updates the UI CellPanelGrid with its own copy of the Automata array
         * - waits speed ms
         *
         * When the isRuning flag is false:
         * - updates the Automata array by a user modified copy of it in the CellPanelGrid UI
         */
        @Override
        public void run(){
            while (true)
                if (isRunning){
                    automata.evolve();
                    cellGridPanelController.setAutomataCopy(automata.getGrid());
                    cellGridPanelController.fillCellPanelGrid();
                    try{
                        Thread.sleep(speed);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                else
                    automata.setGrid(cellGridPanelController.getAutomataCopy());
        }
    }

    private void addGUIEventListeners() {
        guiFrame.getStartStopButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startStopEvolution();
            }
        });
        guiFrame.getRandomizeGridButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                randomizeGrid();
            }
        });
        guiFrame.getClearGridButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                clearGrid();
            }
        });
    }

    /* Changes the state of the isRunning flag,
    *  modifies the setEnabled property of the JButton elements
    */
    private void startStopEvolution(){
        if (!isRunning){
            guiFrame.getStartStopButton().setText("Stop");
            guiFrame.getRandomizeGridButton().setEnabled(false);
            guiFrame.getClearGridButton().setEnabled(false);
            isRunning = true;
        }
        else{
            guiFrame.getStartStopButton().setText("Resume");
            guiFrame.getRandomizeGridButton().setEnabled(true);
            guiFrame.getClearGridButton().setEnabled(true);
            isRunning = false;
        }
    }

    /* Initializes the Automata model with random values,
     * fills the values of the
     */
    private void randomizeGrid(){
        automata.randomInit();
        cellGridPanelController.fillCellPanelGrid();
    }

    /* Reinitializes the Automata model with dead(0) values,
     * calls the emptyGrid method to set all CellPanels to dead state
     */
    private void clearGrid(){
        automata.init();
        cellGridPanelController.setAutomataCopy(automata.getGrid());
        cellGridPanelController.emptyGrid();
    }
}
