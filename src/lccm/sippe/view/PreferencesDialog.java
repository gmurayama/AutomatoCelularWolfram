package lccm.sippe.view;

import lccm.sippe.model.GamePreferences;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 * @author: Luis Carlos Castillo Martinez on 27/01/16.
 * Université Blaise Pascal
 * lcarlos.asimov@gmail.com
 * github.com/luisccastillo
 */
public class PreferencesDialog extends JDialog {

    private JButton okButton;
    private JButton cancelButton;
    private JButton aliveCellGridColorButton;
    private JButton deadCellGridColorButton;
    private JButton borderColorButton;
    private JButton hooverColorButton;
    private JCheckBox displayBordersCheckBox;
    private static int WIDTH = 300;
    private static int HEIGHT = 250;
    private static List<Color> colors = new ArrayList<Color>
            (Arrays.asList(Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN,
                    Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW));

    public PreferencesDialog(JFrame parentJFrame){
        this.setLocationRelativeTo(parentJFrame);
        initialize();
    }

    private void initialize(){

        okButton = new JButton("Ok");
        cancelButton = new JButton("Cancel");
        aliveCellGridColorButton = new JButton("");
        deadCellGridColorButton = new JButton("");
        displayBordersCheckBox = new JCheckBox("");

        Container dialogPane = getContentPane();
        dialogPane.setLayout(new BorderLayout());


        this.setTitle("Preferences");
        this.setSize(new Dimension(HEIGHT, WIDTH));
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

        getAliveCellGridColorButton().setBounds(0, 0, 100, 60);
        getAliveCellGridColorButton().setBackground(GamePreferences.getAliveCellColor());
        getDeadCellGridColorButton().setBounds(0, 0, 100, 60);
        getDeadCellGridColorButton().setBackground(GamePreferences.getDeadCellColor());
        getDisplayBordersCheckBox().setSelected(GamePreferences.isBorderedGrid());

        //borderlayout: center
        JPanel verticalLayoutPanel;
        verticalLayoutPanel = new JPanel();
        verticalLayoutPanel.setLayout(new BoxLayout(verticalLayoutPanel, BoxLayout.Y_AXIS));

        JPanel flowLayoutPanel;
        flowLayoutPanel = new JPanel();
        flowLayoutPanel.setBorder(BorderFactory.createTitledBorder("Visual"));
        flowLayoutPanel.add(new JLabel("Alive cell color: "));
        flowLayoutPanel.add(getAliveCellGridColorButton());
        flowLayoutPanel.add(new JLabel("Dead cell color: "));
        flowLayoutPanel.add(getDeadCellGridColorButton());
        flowLayoutPanel.add(new JLabel("Draw borders: "));
        flowLayoutPanel.add(getDisplayBordersCheckBox());
        verticalLayoutPanel.add(flowLayoutPanel);

        flowLayoutPanel = new JPanel();
        flowLayoutPanel.setBorder(BorderFactory.createTitledBorder("Game"));
        flowLayoutPanel.add(new JLabel(""));
        verticalLayoutPanel.add(flowLayoutPanel);


        dialogPane.add(verticalLayoutPanel,BorderLayout.CENTER);

        //borderlayout: south
        flowLayoutPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        flowLayoutPanel.add(getOkButton());
        flowLayoutPanel.add(getCancelButton());
        dialogPane.add(flowLayoutPanel,BorderLayout.SOUTH);

        addGUIEventListeners();
        this.setModal(true);
        this.setVisible(false);
    }

    private void addGUIEventListeners(){
        getDeadCellGridColorButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                changeButtonBackgroundColor(getDeadCellGridColorButton());
            }
        });
        getAliveCellGridColorButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                changeButtonBackgroundColor(getAliveCellGridColorButton());
            }
        });
    }


    private void changeButtonBackgroundColor(JButton jButton){
        Color currentColor = jButton.getBackground();
        int index = colors.indexOf(currentColor);
        if (index == colors.size() -1)
            jButton.setBackground(colors.get(0));
        else
            jButton.setBackground(colors.get(index + 1));
    }

    public Color getAliveCellColor(){
        return aliveCellGridColorButton.getBackground();
    }

    public Color getDeadCellColor(){
        return deadCellGridColorButton.getBackground();
    }

    public JButton getAliveCellGridColorButton(){ return aliveCellGridColorButton; }

    public JButton getDeadCellGridColorButton(){ return deadCellGridColorButton; }

    public JCheckBox getDisplayBordersCheckBox(){ return displayBordersCheckBox; }

    public boolean displaysBorders(){
        if (displayBordersCheckBox.isSelected())
            return true;
        else
            return false;
    }

    public JButton getOkButton() {
        return okButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }


}

