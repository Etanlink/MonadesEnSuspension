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
	
	/* TODO : Method to define a moving */
	public Position toMove(Position currentPosition){
		
		return currentPosition.nextPosition();
	}

}
