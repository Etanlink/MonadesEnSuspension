package model;

public abstract class AbstractMonade {
	
	
	public enum size {PETIT, MOYEN, GRAND};
	
	private Position currentPosition;
	
	private Position nextPosition;

	public AbstractMonade(Position currentPosition, Position nextPosition) {
		super();
		this.currentPosition = currentPosition;
		this.nextPosition = nextPosition;
	}

	public Position getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(Position currentPosition) {
		this.currentPosition = currentPosition;
	}

	public Position getNextPosition() {
		return nextPosition;
	}

	public void setNextPosition(Position nextPosition) {
		this.nextPosition = nextPosition;
	}
	
	

}
