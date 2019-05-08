package lccm.sippe.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * @author: Mamadou Kaba Traoré traore@isima.fr modifications by Luis Carlos
 * Castillo Martinez Université Blaise Pascal lcarlos.asimov@gmail.com
 * github.com/luisccastillo
 */
public class Automata {

    private boolean grid[][], clone[][];
    private static final Random random = new Random();
    private final ArrayList<String> survivalRules;

    public Automata(int lineNb, int columnNb, String[] survivalRules) {
        grid = new boolean[lineNb][columnNb];
        clone = new boolean[lineNb][columnNb];
        this.survivalRules = new ArrayList<>(Arrays.asList(survivalRules));
    }

    public boolean[][] getGrid() {
        return grid;
    }

    public void setGrid(boolean[][] grid) {
        this.grid = grid;
    }

    /**
     * Initializes the grid array with empty values
     */
    public void init() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = false;
                clone[i][j] = false;
            }
        }
    }

    /**
     * Initializes the grid array with random values
     */
    public void randomInit() {
        for (int j = 0; j < grid[0].length; j++) {
            grid[0][j] = random.nextBoolean();
        }
    }

    /*
     Counts the number of alive (true) cells according to a i,j position
     */
    private String getCurrentState(int i, int j) {
        int left, middle, right, index;

        index = j - 1 < 0 ? grid[0].length - 1 : j - 1;
        left = grid[i][index] ? 1 : 0;

        middle = grid[i][j] ? 1 : 0;

        index = j + 1 >= grid[0].length ? 0 : j + 1;
        right = grid[i][index] ? 1 : 0;

        return String.format("%s%s%s", left, middle, right);
    }

    /**
     * Evaluates the count of living neighbors in a cell to set its state to
     * survival, death, or birth
     */
    public void evolve(int step) {
        String currentState;

        if (step < grid.length - 1) {
            for (int j = 0; j < grid[step].length; j++) {
                currentState = getCurrentState(step, j);

                if (survivalRules.contains(currentState)) {
                    clone[step][j] = true;
                } else {
                    clone[step][j] = false;
                }
            }

            System.arraycopy(clone[step], 0, grid[step + 1], 0, grid[step].length);
        }
    }
}
