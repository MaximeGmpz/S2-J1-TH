package org.treasurehunt.plateau;

//@author Thomas Plouchart
public class Board extends Cell {

	/** the size of the board in height. */
	private int sizeHeight = 10;

	/** the size of the board in width. */
	private int sizeWidth = 10;

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

	// //incompete Manque généreation des rochets
	/**
	 * generate the board with size and obstacles
	 */
	private void generate() {
		plateau = new Cell[sizeWidth][sizeHeight];
		for (int i = 0; i < plateau.length; i++) {
			for (int j = 0; j < plateau[0].length; j++) {
				plateau[i][j] = new Cell();
			}
		}
		plateau[0][0].setBase(1);
		plateau[sizeWidth - 1][sizeHeight - 1].setBase(2);

		
		
		//ici pour toute la génération de la carte
		
		
		
		
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
