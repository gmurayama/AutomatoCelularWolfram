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
    private static int CELL_GRID_SIZE = 50;
    private static boolean BORDERED_GRID = true;
    private final static String[] RULE_NAMES = {"Conway's Life", "2 x 2", "Amoeba", "Assimilation",
                                          "Diamoeba",  "Flakes", "Gnarl", "Maze", "Walled Cities",
                                           "Long life", "Day & Night", "Mazectric", "Replicator", "Mamadou" };

    private final static String[] SURVIVAL_PRESETS = {"2,3", "1,2,5", "1,3,5,8", "4,5,6,7",
                                                "5,6,7,8", "0,1,2,3,4,5,6,7,8", "1",
                                                "1,2,3,4,5", "2,3,4,5", "5", "3,4,6,7,8",
                                                "1,2,3,4", "1,3,5,7", "2,3"};
    private final static String[] BIRTH_PRESETS = {"3", "3,6", "3,5,7", "3,4,5", "3,5,6,7,8", "3",
                                                "1", "3", "4,5,6,7,8", "3, 4, 5","3,6,7,8", "3",
                                                "1,3,5,7","3,4,5,6,7,8"};

    private static String SURVIVAL_PRESET = SURVIVAL_PRESETS[0];

    private static String BIRTH_PRESET = BIRTH_PRESETS[0];

    private GamePreferences(){
    }

    public static String getSurvivalPresetAt(int index){
        return SURVIVAL_PRESETS[index];
    }

    public static void setSurvivalPreset(String survivalPreset){
        SURVIVAL_PRESET = survivalPreset;
    }

    public static String getBirthPresetAt(int index){
        return BIRTH_PRESETS[index];
    }

    public static void setBirthPreset(String birthPreset){
        BIRTH_PRESET = birthPreset;
    }

    public static String getSurvivalPreset(){
        return SURVIVAL_PRESET;
    }

    public static String getBirthPreset(){
        return BIRTH_PRESET;
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
