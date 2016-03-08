package com.plateau;
//@author Maxime Guermonprez
public class Cell {

	private boolean obstacle = false;
	
	private boolean chest = false;
	
	private boolean key = false;
	
	private Unit unit;
	
	
	
	/**
	 * Check if any robots can do somthing
	 *
	 * @param lsRobot
	 *            the list robot
	 * @return true, if anything to do
	 */
	public boolean anyCanDo(List<Robot> lsRobot) {
		for (Robot rob : lsRobot) {
			if (rob.getAvailableAtacks() != null
					|| rob.getAvailableMove() != null) {
				return true;
			}
		}
		return false;
	}
	
}
