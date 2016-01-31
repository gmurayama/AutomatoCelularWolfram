package lccm.sippe.controller;

import lccm.sippe.model.Automata;
import lccm.sippe.model.GamePreferences;
import lccm.sippe.view.GUIFrame;
import lccm.sippe.view.PreferencesDialog;

import java.awt.*;
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
    private PreferencesDialog preferencesDialog;
    private Automata automata;
    private boolean isRunning;
    private int speed;

    public MainController(){
        createGame();
        initialize();
    }

    private void createGame(){
        int gameSize = GamePreferences.getCellGridSize();
        this.guiFrame = new GUIFrame(gameSize, gameSize);
        this.automata = new Automata(gameSize, gameSize);
        this.cellGridPanelController = guiFrame.getCellGridPanelController();
        this.preferencesDialog  = new PreferencesDialog(guiFrame);
    }

    /* MainController initialization tasks:
    *  - intializes the Automata object with empty values
    *  - intializes the isRunning flag to false
    *  - sets the Automata array as a copy to the CellPanelController
    *  - updates the CellPanel grid with its own copy of the Automata array
    *  - starts the Evolution thread
    */
    private void initialize(){
        automata.init();
        isRunning = false;
        speed = guiFrame.getSpeedSlider().getValue();
        //cellGridPanelController.setAutomataCopy(automata.getGrid());
        addGUIEventListeners();
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
                    //guiFrame.getAliveCellsLabel().setText("Alive Cells: "+ cellGridPanelController.getAliveCells());
                    try{
                        Thread.sleep(speed);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                else {
                    automata.setGrid(cellGridPanelController.getAutomataCopy());
                }
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
        guiFrame.getPreferencesMenu().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                openPreferencesDialog();
            }
        });
        preferencesDialog.getCancelButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {closePreferencesDialog();
            }
        });
        preferencesDialog.getOkButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                savePreferences();
                createNewGame();
            }
        });
    }

    /*
     * Creates a new automata object with a new size, as well as
     * a  cellGridPanelController object with new UI properties
     */
    private void createNewGame(){
        int boardSize = GamePreferences.getCellGridSize();
        automata = new Automata(boardSize, boardSize);
        guiFrame.remove(cellGridPanelController);
        cellGridPanelController = new CellPanelGridController(boardSize, boardSize);
        guiFrame.add(cellGridPanelController, BorderLayout.CENTER);
        guiFrame.validate();
        guiFrame.repaint();
    }

    private void openPreferencesDialog(){
        preferencesDialog.setVisible(true);
    }

    private void closePreferencesDialog() {
        preferencesDialog.dispose();
    }

    /*
    * Modifies the properties of the Preferences static class with
    * new user entered values
    */
    private void savePreferences(){
        GamePreferences.setAliveCellColor(preferencesDialog.getAliveCellColor());
        GamePreferences.setDeadCellColor(preferencesDialog.getDeadCellColor());
        GamePreferences.setBorderedGrid(preferencesDialog.displaysBorders());
        GamePreferences.setBorderColor(preferencesDialog.getBorderCellColor());
        GamePreferences.setCellPointerColor(preferencesDialog.getCellPointerColor());
        GamePreferences.setCellGridSize(preferencesDialog.getCellGridSize());
        preferencesDialog.dispose();
    }

    /* Changes the state of the isRunning flag,
    *  modifies the setEnabled property of the JButton elements
    */
    private void startStopEvolution(){
        if (!isRunning){
            guiFrame.getStartStopButton().setText("Stop");
            guiFrame.getRandomizeGridButton().setEnabled(false);
            guiFrame.getClearGridButton().setEnabled(false);
            guiFrame.getSpeedSlider().setEnabled(false);
            guiFrame.getPreferencesMenu().setEnabled(false);
            speed = guiFrame.getSpeedSlider().getValue();
            isRunning = true;
        }
        else{
            guiFrame.getStartStopButton().setText("Resume");
            guiFrame.getRandomizeGridButton().setEnabled(true);
            guiFrame.getClearGridButton().setEnabled(true);
            guiFrame.getSpeedSlider().setEnabled(true);
            guiFrame.getPreferencesMenu().setEnabled(true);
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
     * calls the emptyGrid method to set all UI CellPanels to a dead state
     */
    private void clearGrid(){
        automata.init();
        cellGridPanelController.setAutomataCopy(automata.getGrid());
        cellGridPanelController.emptyGrid();
    }
}
