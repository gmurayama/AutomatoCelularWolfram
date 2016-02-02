package lccm.sippe.view;

import lccm.sippe.controller.CellPanelGridController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;

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
    private JMenuItem preferencesMenu;
    private JSlider speedSlider;
    private JMenuItem aboutMenu;
    private CellPanelGridController cellGridPanelController;
    private static int MIN_SIZE = 400;
    private static int DEFAULT_SIZE = 10;

    public GUIFrame(){
        setCellGridPanelController(new CellPanelGridController(DEFAULT_SIZE, DEFAULT_SIZE));
        initGUI();
    }

    public GUIFrame(int xCellCount, int yCellCount){
        setCellGridPanelController(new CellPanelGridController(xCellCount, yCellCount));
        initGUI();
    }

    private void initGUI(){
        //Window and layout properties
        this.setMinimumSize(new Dimension(MIN_SIZE, MIN_SIZE));
        this.setSize(new Dimension(MIN_SIZE + 200, MIN_SIZE + 300));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Conway's Life  & families simulator");
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        jPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        //menu bar
        JMenu jMenu;
        JMenuBar jMenuBar = new JMenuBar();
        jMenu = new JMenu("File");
        jMenu.setMnemonic(KeyEvent.VK_F);
        jMenuBar.add(jMenu);
        setPreferencesMenu(new JMenuItem("Preferences"));
        jMenu.add(getPreferencesMenu());
        jMenu = new JMenu("About");
        jMenu.setMnemonic(KeyEvent.VK_A);
        jMenuBar.add(jMenu);
        setAboutMenu(new JMenuItem("About Swing GoL..."));
        jMenu.add(getAboutMenu());

        //dashboard: center
        jPanel.add(getCellGridPanelController(), BorderLayout.CENTER);

        //dashboard: south
        JPanel flowLayoutPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        flowLayoutPanel.add(new JLabel("Speed:"));
        setSpeedSlider(new JSlider(50, 500, 250));
        getSpeedSlider().setMinorTickSpacing(50);
        getSpeedSlider().setInverted(true);
        getSpeedSlider().setSnapToTicks(true);
        flowLayoutPanel.add(getSpeedSlider());
        setClearGridButton(new JButton("Clear"));
        getClearGridButton().setMnemonic(KeyEvent.VK_C);
        flowLayoutPanel.add(getClearGridButton());
        setRandomizeGridButton(new JButton("Randomize"));
        getRandomizeGridButton().setMnemonic(KeyEvent.VK_R);
        flowLayoutPanel.add(getRandomizeGridButton());
        flowLayoutPanel.add(new JSeparator(SwingConstants.VERTICAL));
        setStartStopButton(new JButton("Start"));
        getStartStopButton().setMnemonic(KeyEvent.VK_S);
        flowLayoutPanel.add(getStartStopButton());
        jPanel.add(flowLayoutPanel, BorderLayout.SOUTH);

        this.setJMenuBar(jMenuBar);
        this.setContentPane(jPanel);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public JMenuItem getPreferencesMenu() {
        return preferencesMenu;
    }

    public void setPreferencesMenu(JMenuItem preferencesMenu) {
        this.preferencesMenu = preferencesMenu;
    }

    public JMenuItem getAboutMenu() {
        return aboutMenu;
    }

    public void setAboutMenu(JMenuItem aboutMenu) {
        this.aboutMenu = aboutMenu;
    }

    public CellPanelGridController getCellGridPanelController() {
        return cellGridPanelController;
    }

    public void setCellGridPanelController(CellPanelGridController cellGridPanelController) {
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

    public JSlider getSpeedSlider() {
        return speedSlider;
    }

    public void setSpeedSlider(JSlider speedSlider) {
        this.speedSlider = speedSlider;
    }
}
