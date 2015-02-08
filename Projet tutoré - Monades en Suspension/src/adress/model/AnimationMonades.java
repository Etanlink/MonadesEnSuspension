/**
 * @aim Create an animation with different parameters
 * 
 * @date 23/01/2015
 * @author HugoPopo, Etanlink
 * @version 0.0
 *
 **/

package adress.model;
import java.util.ArrayList;
import java.util.Random;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
public class AnimationMonades {
	
	/**Unique instance of the PhysicalInstance, following the pattern Singleton*/
	private final static AnimationMonades INSTANCE = new AnimationMonades();
	
	/**List of the monades on the scene */
	private static ArrayList<Monade> listMonades;
	
	private static ArrayList<Circle> listCercles;
	
	
	private Stage mainStage;
	
	/**Empty builder*/
	private AnimationMonades(){ };
	
	public static AnimationMonades getPhysicalEngine()
	{
		return INSTANCE;
	}
	
	public static ArrayList<Monade> getListMonades()
	{
		return listMonades;
	}
	
	public Stage getMainStage() {
		return mainStage;
	}

	public void setMainStage(Stage mainStage) {
		this.mainStage = mainStage;
	}
	
	/**creates a new monade and inserts it in ListMonades*/
	public void createANewMonade(double x, double y, double radius)
	{
		Monade monade = new Monade(x, y , radius);
		monade.createANewTranslation();
		getListMonades().add(monade);
	}
	
	/**creates an animation considering parameters
	 * @param param the different parameters defined by the user
	 * */
	public void createAnimation(/*Parameters param*/){
		final Pane root = new Pane();
		final Scene scene = new Scene(root, 800, 400);
		this.getMainStage().setScene(scene);
		
		double xPrime = 50;
		double yPrime = 50;
		double radPrime = 50;
		
		Random rand = new Random();
		float p = rand.nextFloat();
		
		while(true){
			while(listMonades.size()<=3)
			{
				xPrime += 75;
				yPrime += 75;
				createANewMonade(xPrime, yPrime, radPrime);
			}
			/*
			if(listMonades.size()<10)
			{
				createANewMonade();
			}*/
			for(Monade m : listMonades)
			{
				root.getChildren().add(m);
			}
			updateListMonades();
		}
			
		
	}
	
	public void createAnimation2(/*Parameters param*/){
		final Pane root = new Pane();
		final Scene scene = new Scene(root, 1600, 900);
		this.getMainStage().setScene(scene);
		this.getMainStage().setTitle("Cercles en suspension");
		this.getMainStage().show();
		
		final Circle circ1 = new Circle(100, 100, 100);         
        circ1.setFill(Color.RED);
        final Circle circ2 = new Circle(200, 200, 50);         
        circ2.setFill(Color.RED);
        final Circle circ3 = new Circle(300, 300, 75);         
        circ3.setFill(Color.RED);
        
        root.getChildren().setAll(circ1, circ2, circ3);
        final TranslateTransition translateAnimation = new TranslateTransition(Duration.seconds(2)); 
        translateAnimation.setCycleCount(TranslateTransition.INDEFINITE); 
        translateAnimation.setAutoReverse(true); 
        translateAnimation.setByX(50); 
        translateAnimation.setByY(75); 
        translateAnimation.setInterpolator(Interpolator.LINEAR);
        translateAnimation.setNode(circ1);
        translateAnimation.play();
        
        final TranslateTransition translateAnimation2 = new TranslateTransition(Duration.seconds(4)); 
        translateAnimation2.setCycleCount(TranslateTransition.INDEFINITE); 
        translateAnimation2.setAutoReverse(true); 
        translateAnimation2.setByX(-50); 
        translateAnimation2.setByY(160); 
        translateAnimation2.setInterpolator(Interpolator.LINEAR);
        translateAnimation2.setNode(circ2);
        translateAnimation2.play();
        
		
	}

	/**updates listMonades calculating each monade's nextPosition*/
	private void updateListMonades() {
		// TODO Auto-generated method stub
		for(Monade m : listMonades)
		{
			m.updateTranslation();
		}
	}



}
