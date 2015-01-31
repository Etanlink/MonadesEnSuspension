package model;

public class Vector {
	
	private float x;
	
	private float y;

	public Vector(float x, float y) {
		super();
		this.x = x;
		this.y = y;
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
	
	public float getNorm()
	{
		return (float)Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
	}

}
