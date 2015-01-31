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
	 * Method to obtain a next x position
	 * @param Position nextX
	 * @return a next x position
	 */
	public Position nextX(Position nextX) {
		setX(nextX);
		return nextX;
	}
	/**
	 * Method to obtain a next y position
	 * @param Position nextY
	 * @return a next y position
	 */
	public Position nextY(Position nextY) {
		setY(nextY);
		return nextY;
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
