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
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Transform;
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
		Scene scene = this.getMainStage().getScene();
		Pane root = (Pane) scene.getRoot();
		
		final Circle circ1 = new Circle(100, 100, 100);         
        circ1.setFill(Color.RED);
        
        TranslateTransition translateAnimation = new TranslateTransition(Duration.seconds(2), circ1); 
        translateAnimation.setCycleCount(TranslateTransition.INDEFINITE); 
        translateAnimation.setAutoReverse(true); 
        translateAnimation.setByX(50); 
        translateAnimation.setByY(75); 
        translateAnimation.setInterpolator(Interpolator.LINEAR);
        
        //circ1.getTransforms().add(translateAnimation);
        
        Timeline animation = new Timeline( new KeyFrame(Duration.seconds(0.5),
        	    		  new KeyValue(new TranslateTransition().byXProperty(),50)));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
        
        
        
		
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
