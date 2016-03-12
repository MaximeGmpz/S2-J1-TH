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

	/** 
	 * 
	 * @return true if cell is a base
	 */
	public boolean isBase(){
		return !(this.base == 0);
	}
	/**
	 * 
	 * @return true if cell is an obstacle
	 */
	public boolean isObstacle(){
		return !(this.obstacle == 0);
	}
	/**
	 * 
	 * @return true if cell contain a trap
	 */
	public boolean isTrap() {
		return trap;
	}
	/**
	 * 
	 * @param trap
	 */
	public void setTrap(boolean trap) {
		this.trap = trap;
	}
	/**
	 * 
	 * @return an integer corresponding to the kind of obstacle
	 */
	public int getObstacle() {
		return obstacle;
	}
	/**
	 * 
	 * @param obstacle
	 */
	public void setObstacle(int obstacle) {
		this.obstacle = obstacle;
	}
	/**
	 * 
	 * @return an integer corresponding to the team of the base
	 */
	public int getBase() {
		return base;
	}
	/**
	 * 
	 * @param base
	 */
	public void setBase(int base) {
		this.base = base;
	}
}
