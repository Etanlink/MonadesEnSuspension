package adress.model;

import javafx.scene.shape.Circle;

/**
 * Circle with observable coordinates
 * @author Hugo
 *
 */
public class ExtentedCircle extends Circle {
	
	private double x;
	
	private double y;
	
	public ExtentedCircle(double x, double y, double r) {
		super(x, y, r);
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	
	
	

}
