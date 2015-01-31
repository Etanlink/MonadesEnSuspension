package model;

/**
 * @aim Define a Monade object to create and display it
 * 
 * @date 23/01/2015
 * @author HugoPopo, Etanlink
 * @version 0.0
 *
 **/

public class Monades {
	
	public enum size {PETIT, MOYEN, GRAND};
	public float speedVector;
	
	
	private Position currentX;
	private Position currentY;
	
	/**
	 * Method to give a new Position in x and y at a Monade object 
	 * @param newX corresponds at the new x position wished
	 * @param newY corresponds at the new y position wished
	 */
	public void toMove(Position newX, Position newY){
		currentX.nextX(newX);
		currentY.nextY(newY);
	}

}
