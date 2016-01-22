package lccm.sippe.view;

import lccm.sippe.controller.CellGridPanelController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * @author: Luis Carlos Castillo Martinez on 18/01/16.
 * Université Blaise Pascal
 * lcarlos.asimov@gmail.com
 * github.com/luisccastillo
 */
public class GUIFrame extends JFrame{

    private JButton startStopButton;
    private JButton clearGridButton;
    private JButton randomizeGridButton;
    private JMenuItem newSimulationMenu;
    private JLabel aliveCellsLabel;
    private JLabel generationLabel;
    private JMenuItem aboutMenu;
    private CellGridPanelController cellGridPanelController;
    private static int MIN_HEIGHT = 700;
    private static int MIN_WIDTH = 700;
    private static int DEFAULT_SIZE = 10;

    public GUIFrame(){
        setCellGridPanelController(new CellGridPanelController(DEFAULT_SIZE, DEFAULT_SIZE));
        initGUI();
    }

    public GUIFrame(int xCellCount, int yCellCount){
        setCellGridPanelController(new CellGridPanelController(xCellCount, yCellCount));
        initGUI();
    }

    private void initGUI(){
        //Window and layout properties
        this.setMinimumSize(new Dimension(MIN_WIDTH, MIN_HEIGHT));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Game of life");
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        jPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        //menu bar
        JMenu jMenu;
        JMenuBar jMenuBar = new JMenuBar();
        jMenu = new JMenu("File");
        jMenuBar.add(jMenu);
        setNewSimulationMenu(new JMenuItem("Preferences"));
        jMenu.add(getNewSimulationMenu());
        jMenu = new JMenu("Help");
        jMenuBar.add(jMenu);
        setAboutMenu(new JMenuItem("About..."));
        jMenu.add(getAboutMenu());

        //dashboard: north
        JPanel flowLayoutPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        setAliveCellsLabel(new JLabel("Alive cells: 0"));
        flowLayoutPanel.add(getAliveCellsLabel());
        setGenerationLabel(new JLabel("Generation: 0"));
        flowLayoutPanel.add(getGenerationLabel());
        jPanel.add(flowLayoutPanel, BorderLayout.PAGE_START);

        //dashboard: center
        jPanel.add(getCellGridPanelController(), BorderLayout.CENTER);

        //dashboard: south
        flowLayoutPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        setClearGridButton(new JButton("Clear"));
        getClearGridButton().setEnabled(false);
        flowLayoutPanel.add(getClearGridButton());
        setRandomizeGridButton(new JButton("Randomize"));
        flowLayoutPanel.add(getRandomizeGridButton());
        flowLayoutPanel.add(new JSeparator(SwingConstants.VERTICAL));
        setStartStopButton(new JButton("Start"));
        flowLayoutPanel.add(getStartStopButton());
        jPanel.add(flowLayoutPanel, BorderLayout.SOUTH);

        this.setJMenuBar(jMenuBar);
        this.setContentPane(jPanel);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }



    public JMenuItem getNewSimulationMenu() {
        return newSimulationMenu;
    }

    public void setNewSimulationMenu(JMenuItem newSimulationMenu) {
        this.newSimulationMenu = newSimulationMenu;
    }

    public JMenuItem getAboutMenu() {
        return aboutMenu;
    }

    public void setAboutMenu(JMenuItem aboutMenu) {
        this.aboutMenu = aboutMenu;
    }

    public CellGridPanelController getCellGridPanelController() {
        return cellGridPanelController;
    }

    public void setCellGridPanelController(CellGridPanelController cellGridPanelController) {
        this.cellGridPanelController = cellGridPanelController;
    }

    public JButton getStartStopButton() {
        return startStopButton;
    }

    public void setStartStopButton(JButton startStopButton) {
        this.startStopButton = startStopButton;
    }

    public JButton getClearGridButton() {
        return clearGridButton;
    }

    public void setClearGridButton(JButton clearGridButton) {
        this.clearGridButton = clearGridButton;
    }

    public JButton getRandomizeGridButton() {
        return randomizeGridButton;
    }

    public void setRandomizeGridButton(JButton randomizeGridButton) {
        this.randomizeGridButton = randomizeGridButton;
    }

    public JLabel getAliveCellsLabel() {
        return aliveCellsLabel;
    }

    public void setAliveCellsLabel(JLabel aliveCellsLabel) {
        this.aliveCellsLabel = aliveCellsLabel;
    }

    public JLabel getGenerationLabel() {
        return generationLabel;
    }

    public void setGenerationLabel(JLabel generationLabel) {
        this.generationLabel = generationLabel;
    }
}
