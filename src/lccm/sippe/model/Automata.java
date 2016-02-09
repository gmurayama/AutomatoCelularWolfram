package lccm.sippe.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * @author: Mamadou Kaba Traoré
 * traore@isima.fr
 * modifications by Luis Carlos Castillo Martinez
 * Université Blaise Pascal
 * lcarlos.asimov@gmail.com
 * github.com/luisccastillo
 */
public class Automata {

	private boolean grid[][], clone[][];
	private static final Random random = new Random();
	private final ArrayList<Integer> survivalRules;
	private final ArrayList<Integer> birthRules;

	public Automata(int lineNb, int columnNb, Integer[] survivalRules, Integer[] birthRules) {
		grid= new boolean[lineNb][columnNb];
		clone = new boolean [lineNb][columnNb];
		this.survivalRules = new ArrayList<>(Arrays.asList(survivalRules));
		this.birthRules = new ArrayList<>(Arrays.asList((birthRules)));
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
	public void randomInit(){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = random.nextBoolean();
            }
        }
	}


	private int countLivingNeighbors(int i, int j) {
		int s = 0;
		if (i>0)
			s = s + (grid[i-1][j] ? 1:0);
		if ((i>0) && (j<grid[0].length-1))
			s = s + (grid[i-1][j+1]? 1:0);
		if (j<grid[0].length-1)
			s =s + (grid[i][j+1]? 1:0);
		if ((i<grid.length-1) && (j<grid[0].length-1))
			s = s + (grid[i+1][j+1]? 1:0);
		if (i<grid.length-1)
			s = s + (grid[i+1][j]? 1:0);
		if ((i<grid.length-1) && (j>0))
			s = s + (grid[i+1][j-1]? 1:0);
		if (j>0)
			s = s + (grid[i][j-1]? 1:0);
		if ((i>0) && (j>0))
			s = s + (grid[i-1][j-1]? 1:0);
		return s;

		/*
		if (i>0) s=s+grid[i-1][j];
		if ((i>0) && (j<grid[0].length-1)) s=s+grid[i-1][j+1];
		if (j<grid[0].length-1) s=s+grid[i][j+1];
		if ((i<grid.length-1) && (j<grid[0].length-1)) s=s+grid[i+1][j+1];
		if (i<grid.length-1) s=s+grid[i+1][j];
		if ((i<grid.length-1) && (j>0)) s=s+grid[i+1][j-1];
		if (j>0) s=s+grid[i][j-1];
		if ((i>0) && (j>0)) s=s+grid[i-1][j-1];
		return s;
		 */
	}

	/**
    * Evaluates the count of living neighbors in a cell to set its state to
	 * survival, death, or birth
    */
	public void evolve() {
		int nbLivNgb;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				nbLivNgb = countLivingNeighbors(i, j);
                if (grid[i][j] == true) {
					if (survivalRules.contains(nbLivNgb))
						clone[i][j] = true;
					else
						clone[i][j] = false;
				}
                else {
					if (birthRules.contains(nbLivNgb))
                        clone[i][j] = true;
					else
						clone[i][j] = false;
                }
			}
		}

		for (int i = 0; i < grid.length; i++) {
			System.arraycopy(clone[i], 0, grid[i], 0, grid[0].length);
		}
	}
}