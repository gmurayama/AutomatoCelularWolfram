package lccm.sippe.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Created by duder on 13/01/16.
 */
public class GUIFrame extends JFrame{

    private JButton nextButton;
    private JButton prevButton;
    private JMenuItem newSimulationMenu;
    private JMenuItem aboutMenu;
    private JTextArea historyTextArea;
    private CellGridPanel cellGridPanel;
    private int MIN_HEIGHT = 500;
    private int MIN_WIDTH = 600;

    public GUIFrame(){
        setCellGridPanel(new CellGridPanel(50,50));
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
        setNewSimulationMenu(new JMenuItem("New simulation"));
        jMenu.add(getNewSimulationMenu());
        jMenu = new JMenu("Help");
        jMenuBar.add(jMenu);
        setAboutMenu(new JMenuItem("About..."));
        jMenu.add(getAboutMenu());

        //dashboard: north
        JPanel flowLayoutPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,40,0));
        flowLayoutPanel.add(new JLabel("History"));
        flowLayoutPanel.add(new JLabel("Generation"));
        jPanel.add(flowLayoutPanel, BorderLayout.PAGE_START);

        //dashboard: center
        setHistoryTextArea(new JTextArea());
        getHistoryTextArea().setRows(10);
        getHistoryTextArea().setColumns(10);
        getHistoryTextArea().setEnabled(false);
        JScrollPane jScrollPane = new JScrollPane(getHistoryTextArea());
        jPanel.add(jScrollPane, BorderLayout.LINE_START);
        //Drawing panel
        jPanel.add(getCellGridPanel(), BorderLayout.CENTER);

        //dashboard: south
        flowLayoutPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        setNextButton(new JButton("Next"));
        setPrevButton(new JButton("Prev"));
        flowLayoutPanel.add(getPrevButton());
        flowLayoutPanel.add(getNextButton());
        jPanel.add(flowLayoutPanel, BorderLayout.SOUTH);

        this.setJMenuBar(jMenuBar);
        this.setContentPane(jPanel);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public JButton getNextButton() {
        return nextButton;
    }

    public void setNextButton(JButton nextButton) {
        this.nextButton = nextButton;
    }

    public JButton getPrevButton() {
        return prevButton;
    }

    public void setPrevButton(JButton prevButton) {
        this.prevButton = prevButton;
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

    public JTextArea getHistoryTextArea() {
        return historyTextArea;
    }

    public void setHistoryTextArea(JTextArea historyTextArea) {
        this.historyTextArea = historyTextArea;
    }

    public CellGridPanel getCellGridPanel() {
        return cellGridPanel;
    }

    public void setCellGridPanel(CellGridPanel cellGridPanel) {
        this.cellGridPanel = cellGridPanel;
    }
}
