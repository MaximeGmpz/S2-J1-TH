package org.treasurehunt.plateau;

//@author Maxime Guermonprez
public class Cell {

	private boolean trap = false;

	/**
	 * 0 for not
	 * 1 for a present rock
	 * 2 with key
	 * 3 with chest
	 */
	private int obstacle = 0;

	/**
	 * 0 for not
	 * 1 for team 1
	 * 2 for team 2 ...
	 */
	private int base = 0;
	
	// private Unit unit;
	
	Cell(){}

	
	public boolean isBase(){
		return (this.base == 0) ? false : true;
	}
	
	public boolean isObstacle(){
		return (this.obstacle == 0) ? false : true;
	}
	
	public boolean isTrap() {
		return trap;
	}

	public void setTrap(boolean trap) {
		this.trap = trap;
	}

	public int getObstacle() {
		return obstacle;
	}

	public void setObstacle(int obstacle) {
		this.obstacle = obstacle;
	}

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}
}
