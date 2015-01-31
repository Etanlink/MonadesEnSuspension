package model;

public class Position {
	
	private float x;
	private float y;
	
	/**
	 * Constructor of the Position class
	 * @param xi -> x initial
	 * @param yi -> y initial
	 */
	public Position(float xi, float yi){
		this.x = xi;
		this.y = yi;
	}
	
	/**
	 * Method to obtain a next x position
	 * @param Position nextX
	 * @return a next x position
	 */
	/*public float nextX(float nextX) {
		setX(nextX);
		return nextX;
	}
	/**
	 * Method to obtain a next y position
	 * @param Position nextY
	 * @return a next y position
	 */
	
	public float nextY(float nextY) {
		setY(nextY);
		return nextY;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

}
