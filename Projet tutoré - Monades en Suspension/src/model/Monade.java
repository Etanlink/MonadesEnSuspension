package model;

import java.util.Random;

import javafx.animation.TranslateTransition;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import com.sun.javafx.geom.PathIterator;
import com.sun.javafx.geom.RectBounds;
import com.sun.javafx.geom.Shape;
import com.sun.javafx.geom.transform.BaseTransform;

/**
 * @aim Define a Monade object to create and display it
 * 
 * @date 23/01/2015
 * @author HugoPopo, Etanlink
 * @version 0.0
 *
 **/

public class Monade extends Circle {
	
	private TranslateTransition transition;

	/**
	 * TODO : Constructor
	 * @param radius 
	 * @param y 
	 * @param x 
	 */
	public Monade(int x, int y, int radius) {
		
	}
	
	public Monade() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Monade(double arg0, double arg1, double arg2, Paint arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public Monade(double arg0, double arg1, double arg2) {
		super(arg0, arg1, arg2);
		// TODO Auto-generated constructor stub
	}

	public Monade(double arg0, Paint arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public Monade(double arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public TranslateTransition getTransition() {
		return transition;
	}

	public void setTransition(TranslateTransition transition) {
		this.transition = transition;
	}

	public void createANewTranslation() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		TranslateTransition trans = new TranslateTransition(Duration.seconds(rand.nextInt(2)));
		this.setTransition(trans);
		trans.setCycleCount(TranslateTransition.INDEFINITE);
		trans.setByX(rand.nextInt(50)); 
        trans.setByY(rand.nextInt(55));
		
	}

	public void updateTranslation() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		this.getTransition().setByX(rand.nextInt(50));
		this.getTransition().setByY(rand.nextInt(50));
		
		
	}
	
}
