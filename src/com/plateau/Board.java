package com.plateau;
//@author Thomas Plouchart
public class Board extends Cell{

	Cell[][] plateau = new Cell[10][10];
	
	
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
