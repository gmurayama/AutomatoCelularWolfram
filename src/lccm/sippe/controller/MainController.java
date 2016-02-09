package lccm.sippe.controller;

import lccm.sippe.model.Automata;
import lccm.sippe.model.GamePreferences;
import lccm.sippe.view.GUIFrame;

import javax.swing.*;
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
    private volatile CellPanelGridController cellGridPanelController;
    private PreferencesDialog preferencesDialog;
    private volatile Automata automata;
    private volatile boolean isRunning;
    private int speed;

    public MainController(){
        createGame();
        initialize();
    }

    private void createGame(){
        int gameSize = GamePreferences.getCellGridSize();
        this.guiFrame = new GUIFrame(gameSize, gameSize);
        Integer[] survivalPreset = stringToIntegerArray(GamePreferences.getSurvivalPreset());
        Integer[] birthPreset = stringToIntegerArray(GamePreferences.getBirthPreset());
        this.automata = new Automata(gameSize, gameSize, survivalPreset, birthPreset);
        this.cellGridPanelController = guiFrame.getCellGridPanelController();
        this.preferencesDialog  = new PreferencesDialog();
    }

    /** MainController initialization tasks:
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
        addGUIEventListeners();
        Thread evolutionThread = new Thread(new EvolutionThread());
        evolutionThread.start();
    }

    private class EvolutionThread implements Runnable{

        /** When the isRunning flag is true:
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
                    cellGridPanelController.setAutomataReference(automata.getGrid());
                    cellGridPanelController.fillCellPanelGrid();
                    try{
                        Thread.sleep(speed);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                else {
                    automata.setGrid(cellGridPanelController.getAutomataReference());
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
        guiFrame.getAboutMenu().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                openAboutDialog();
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
            }
        });
    }

    /**
     * Creates a new automata object with a new size, as well as
     * a  cellGridPanelController object with new UI properties
     */
    private void createNewGame(){
        int boardSize = GamePreferences.getCellGridSize();
        Integer[] survivalPreset = stringToIntegerArray(GamePreferences.getSurvivalPreset());
        Integer[] birthPreset = stringToIntegerArray(GamePreferences.getBirthPreset());
        automata = new Automata(boardSize, boardSize, survivalPreset, birthPreset);
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

    private void openAboutDialog(){
        JOptionPane.showMessageDialog(preferencesDialog, " Swing GoL was made by Luis Carlos Castillo Martinez" +
                "\n inspired on Conway's game of Life and Mirek Wojtowicz MCell" +
                "\n This software is provided under the MIT license.",
                "About Swing GoL",JOptionPane.INFORMATION_MESSAGE);
    }

    /**
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

        String survivalRulesInput = preferencesDialog.getSurvivalRulesTextField().getText();
        String birthRulesInput = preferencesDialog.getBirthRulesTextField().getText();

        if (isValidInput(survivalRulesInput) && isValidInput(birthRulesInput)) {
            GamePreferences.setSurvivalPreset(preferencesDialog.getSurvivalRulePreset());
            GamePreferences.setBirthPreset(preferencesDialog.getBirthRulePreset());
            preferencesDialog.dispose();
            createNewGame();
        }
        else
            JOptionPane.showMessageDialog(preferencesDialog, "Please use the following format: n1,n2,n3",
                    "Rule formatting",JOptionPane.WARNING_MESSAGE);
    }

    private boolean isValidInput(String input){
        return input.matches("[0-8]+(,[$0-8])*");
    }

    /**
     *  Transforms a string into an array of Integers by the split of a ","
     * @param text String to be split
     * @return rules Integer[] the created array with integer values
     */
    private Integer[] stringToIntegerArray(String text){
        String [] textFieldString = text.split(",");
        Integer[] rules = new Integer[textFieldString.length];
        for(int i=0; i<rules.length; i++)
        {
            try{
                rules[i] = Integer.parseInt(textFieldString[i]);
            }
            catch(NumberFormatException nfe){
                nfe.printStackTrace();
            }
        }
        return rules;
    }

    /** Changes the state of the isRunning flag,
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

    /** Initializes the Automata model with random values,
     * fills the values of the
     */
    private void randomizeGrid(){
        automata.randomInit();
        cellGridPanelController.fillCellPanelGrid();
    }

    /** Reinitializes the Automata model with dead(0) values,
     * calls the emptyGrid method to set all UI CellPanels to a dead state
     */
    private void clearGrid(){
        automata.init();
        cellGridPanelController.setAutomataReference(automata.getGrid());
        cellGridPanelController.emptyGrid();
    }
}
