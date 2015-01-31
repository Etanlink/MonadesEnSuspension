package model;

public class Position {
	
	private Position x;
	private Position y;
	
	/**
	 * Constructor of the Position class
	 * @param xi -> x initial
	 * @param yi -> y initial
	 */
	public Position(Position xi, Position yi){
		this.x = xi;
		this.y = yi;
	}
	
	/**
	 * Method to obtain a next position
	 * 
	 * @return a next position
	 */
	public Position nextPosition() {
		/* TODO */
		return null;
	}

	public Position getX() {
		return x;
	}

	public void setX(Position x) {
		this.x = x;
	}

	public Position getY() {
		return y;
	}

	public void setY(Position y) {
		this.y = y;
	}

}
