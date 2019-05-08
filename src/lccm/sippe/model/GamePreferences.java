package lccm.sippe.model;


import java.awt.*;


/**
 * @author: Luis Carlos Castillo Martinez on 28/01/16.
 * Université Blaise Pascal
 * lcarlos.asimov@gmail.com
 * github.com/luisccastillo
 */
public final class GamePreferences{

    private static Color DEAD_CELL_COLOR = Color.DARK_GRAY;
    private static Color ALIVE_CELL_COLOR = Color.GREEN;
    private static Color BORDER_COLOR = Color.BLACK;
    private static Color CELL_POINTER_COLOR = Color.YELLOW;
    private static int CELL_GRID_SIZE = 51;
    private static boolean BORDERED_GRID = true;
    private final static String[] RULE_NAMES = {"Rule 30", "Rule 90", "Rule 184"};

    private final static String[] SURVIVAL_PRESETS = {"100,011,010,001", "110,100,011,001", "111,101,100,011"};

    private static String SURVIVAL_PRESET = SURVIVAL_PRESETS[0];

    private GamePreferences(){
    }

    public static String getSurvivalPresetAt(int index){
        return SURVIVAL_PRESETS[index];
    }

    public static void setSurvivalPreset(String survivalPreset){
        SURVIVAL_PRESET = survivalPreset;
    }

    public static String getSurvivalPreset(){
        return SURVIVAL_PRESET;
    }

    public static Color getDeadCellColor() {
        return DEAD_CELL_COLOR;
    }

    public static void setDeadCellColor(Color deadCellColor) {
        DEAD_CELL_COLOR = deadCellColor;
    }

    public static Color getAliveCellColor() {
        return ALIVE_CELL_COLOR;
    }

    public static Color getCellPointerColor(){
        return CELL_POINTER_COLOR;
    }

    public static void setCellPointerColor(Color cellHooverColor){
        CELL_POINTER_COLOR = cellHooverColor;
    }

    public static void setBorderColor(Color borderColor) {
        BORDER_COLOR = borderColor;
    }

    public static Color getBorderColor() {
        return BORDER_COLOR;
    }

    public static void setAliveCellColor(Color aliveCellColor) {
        ALIVE_CELL_COLOR = aliveCellColor;
    }

    public static int getCellGridSize() {
        return CELL_GRID_SIZE;
    }

    public static void setCellGridSize(int cellGridSize) {
        CELL_GRID_SIZE = cellGridSize;
    }

    public static boolean isBorderedGrid() {
        return BORDERED_GRID;
    }

    public static void setBorderedGrid(boolean borderedGrid) {
        BORDERED_GRID = borderedGrid;
    }

    public static String[] getRULES() {
        return RULE_NAMES;
    }
}
