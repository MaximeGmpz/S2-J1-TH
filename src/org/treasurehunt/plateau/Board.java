package org.treasurehunt.plateau;

import java.util.Random;

//@author Thomas Plouchart
public class Board extends Cell {

	/** the size of the board in height. */
	private int sizeHeight = 10;

	/** the size of the board in width. */
	private int sizeWidth = 10;

	/** percentage of rocks on the board */
	private int percentage = 10;

	/** an array of Cell for store the grind. */
	private Cell[][] plateau;

	public Board() {
		generate();
	}

	public Board(int height, int width) {
		if (height > 2) {
			sizeHeight = height;
		}
		if (width > 2) {
			sizeWidth = width;
		}
		generate();
	}

	// //incompete Manque g�n�reation des rochets
	/**
	 * generate the board with size and obstacles
	 */
	private void generate() {
		boolean key = false; // Is the key already placed
		boolean chest = false; // Is the chest already placed
		
		Random rd = new Random();

		plateau = new Cell[sizeHeight][sizeWidth]; 
		for (int i = 0; i < plateau.length; i++) {
			for (int j = 0; j < plateau[0].length; j++) {
				plateau[i][j] = new Cell();
			}
		}
		//Bases are fixed to left-top angle and right-bottom angle
		plateau[0][0].setBase(1); 
		plateau[sizeHeight - 1][sizeWidth - 1].setBase(2);

		//
		do {
			// generate an obstacle (>0) or not (=0) for each cell
			for (int i = 0; i < sizeHeight; i++) {
				for (int j = 0; j < sizeWidth; j++) {
					if (rd.nextInt(100) <= percentage) {
						do {
							plateau[i][j].setObstacle(rd.nextInt(3) + 1);
						} while ((plateau[i][j].getObstacle() == 2 && key)
								|| (plateau[i][j].getObstacle() == 3 && chest));
						if (plateau[i][j].getObstacle() == 2)
							key = true; // The board can only contain one key
						if (plateau[i][j].getObstacle() == 3)
							chest = true; // The board can only contain one
											// chest

					} else
						plateau[i][j].setObstacle(0);
				}
			}

		} while (!reachable && !key && !chest);

		// ici pour toute la g�n�ration de la carte

	}
	
	private boolean isReachable (Cell[][] plateau) {
		int[][] verification = new int[sizeHeight][sizeWidth];
		verification[0][0]=1;
		for (int i = 0; i < sizeHeight; i++) {
			for (int j=0; j < sizeWidth; j++) {
				if (i!=0 && plateau[i-1][j].getObstacle()==0) verification[i-1][j]=1; else if (i!=0) verification[i-1][j]=1;
				if (j!=0 && plateau[i][j-1].getObstacle()==0) verification[i][j-1]=1; else if (j!=0) verification[i][j-1]=1;
				if (j!=(sizeWidth-1) && plateau[i][j+1].getObstacle()==0) verification[i][j+1]=1; else if (j!=(sizeWidth-1)) verification[i][j+1]=1;
				if (i!=(sizeHeight-1) && plateau[i+1][j].getObstacle()==0) verification[i+1][j]=1; else if (i!=(sizeHeight-1)) verification[i+1][j]=1;
			}
		}
		
		//To be continued
		
	}

	/**
	 * To string.
	 * 
	 * @return return a debug version only with bases and obstacles
	 */
	public String toString() {
		String ret = "";
		for (int i = 0; i < plateau.length; i++) {
			for (int j = 0; j < plateau[0].length; j++) {
				ret += "+---";
			}
			ret += "+\n";
			for (int j = 0; j < plateau[0].length; j++) {
				ret += "|";
				if (plateau[i][j].isBase()) {
					ret += " B ";
				} else {
					if (plateau[i][j].isObstacle()) {
						// don't touch
						if (plateau[i][j].getObstacle() == 2) {
							ret += " K ";
							// don't touch
						} else if (plateau[i][j].getObstacle() == 3) {
							ret += " C ";
						} else {
							ret += " R ";
						}
					} else {
						ret += "   ";
					}
				}
			}
			ret += "|\n";
		}
		for (int j = 0; j < plateau[0].length; j++) {
			ret += "+---";
		}
		ret += "+\n";
		return ret;
	}

	public int getSizeHeight() {
		return sizeHeight;
	}

	public int getSizeWidth() {
		return sizeWidth;
	}
}
