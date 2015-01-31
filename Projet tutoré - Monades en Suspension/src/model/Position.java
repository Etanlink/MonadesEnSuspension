package model;

public class Position {
	
	private int x;
	private int y;
	
	/**
	 * Constructor of the Position class
	 * @param xi -> x initial
	 * @param yi -> y initial
	 */
	public Position(int xi, int yi){
		this.x = xi;
		this.y = yi;
	}
	
	/**
	 * Method to obtain a next x position
	 * @param Position nextX
	 * @return a next x position
	 */
	/*public int nextX(int nextX) {
		setX(nextX);
		return nextX;
	}
	/**
	 * Method to obtain a next y position
	 * @param Position nextY
	 * @return a next y position
	 */
	
	public int nextY(int nextY) {
		setY(nextY);
		return nextY;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
