package model;

public class Position {
	
	private Position x;
	private Position y;
	
	public Position(Position x, Position y){
		this.x = x;
		this.y = y;
	}
	
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
