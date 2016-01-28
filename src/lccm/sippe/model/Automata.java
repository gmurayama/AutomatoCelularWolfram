package lccm.sippe.model;

import java.util.Random;

public class Automata {

	protected int grid[][], clone[][];					// Cells grid and its copy
	static int DIM = 10;								// Default dimension for the grid
	private static Random random = new Random();

	public Automata(int lineNb, int columnNb) {			//	Automata constructor
		grid= new int[lineNb][columnNb];
		clone = new int[lineNb][columnNb];
	}

	public Automata() {									// Automata default constructor
		grid= new int[DIM][DIM];
		clone = new int[DIM][DIM];
	}

	public Automata(Automata aa) {						// Automata cloning constructor
		if (this !=aa) {
			grid = new int[aa.grid.length][aa.grid[0].length];
			clone = new int[aa.grid.length][aa.grid[0].length];
			for (int i = 0; i < aa.grid.length; i++) {
				for (int j = 0; j < aa.grid[0].length; j++) {
					grid[i][j] = aa.grid[i][j];
					clone[i][j] = aa.clone[i][j];
				}
			}
 		}
	}

	public int[][] getGrid() {
		return grid;
	}

	public void setGrid(int[][] grid) {
		this.grid = grid;
	}


	public int getState(int i, int j) {					// Getter for a cell's state
		return grid[i][j];
	}

	public static int getDefaultDimension() {			// Getter for the grid default dimension
		return DIM;
	}

	public void setState(int i, int j, int k) {			// Setter for a cell's state
		grid[i][j] = k;
	}

	public void init() {								// Cells grid random initialization
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				grid[i][j] = 0;
				clone[i][j] = 0;
			}
		}
	}

	public void randomInit(){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = random.nextInt(2);
            }
        }
	}

	private int countLivingNeighbors(int i, int j) {	// Counting of a cell's living neighbors
		int s=0;
		if (i>0) s=s+grid[i-1][j];
		if ((i>0) && (j<grid[0].length-1)) s=s+grid[i-1][j+1];
		if (j<grid[0].length-1) s=s+grid[i][j+1];
		if ((i<grid.length-1) && (j<grid[0].length-1)) s=s+grid[i+1][j+1];
		if (i<grid.length-1) s=s+grid[i+1][j];
		if ((i<grid.length-1) && (j>0)) s=s+grid[i+1][j-1];
		if (j>0) s=s+grid[i][j-1];
		if ((i>0) && (j>0)) s=s+grid[i-1][j-1];
		return s;
	}

/*
    Any live cell with fewer than two live neighbours dies, as if caused by under-population.
    Any live cell with two or three live neighbours lives on to the next generation.
    Any live cell with more than three live neighbours dies, as if by over-population.
    Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
  */
	public void evolve() {								// Evolution to the next generation
		int nbLivNgb;
		for (int i=0; i<grid.length; i++) {
			for (int j=0; j<grid[0].length; j++) {
				nbLivNgb=countLivingNeighbors(i,j);
                if (grid[i][j] == 1) {
                    if (nbLivNgb < 2)
                        clone[i][j] = 0;
                    if ((nbLivNgb == 2 || nbLivNgb == 3))
                        clone[i][j] = 1;
					if (nbLivNgb > 3)
                        clone[i][j]= 0;
                }
                else {
                    if (nbLivNgb == 3)
                        clone[i][j] = 1;
                }
                /*
                if (grid[i][j]==1) {
					if ((nbLivNgb<2)||(nbLivNgb>3)) clone[i][j]=0;
					else clone[i][j]=1;
				}
				else {
					if (nbLivNgb>=3) clone[i][j]=1;
					else clone[i][j]=0;
				}*/
			}
		}

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				grid[i][j] = clone[i][j];
			}
		}

	}

	public void display() {								// Display of the grid
		for (int i=0; i<grid.length; i++) {
			for (int j=0; j<grid[0].length; j++) {
				if (grid[i][j]==1) System.out.print("X");
				else System.out.print("-");
			}
			System.out.println();
		}
	}
}