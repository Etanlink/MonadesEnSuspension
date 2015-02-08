/**
 * @aim Create an animation with different parameters
 * 
 * @date 23/01/2015
 * @author HugoPopo, Etanlink
 * @version 0.0
 *
 **/

package model;
import java.util.ArrayList;
import java.util.Random;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class AnimationMonades {
	
	/**Unique instance of the PhysicalInstance, following the pattern Singleton*/
	private final static AnimationMonades INSTANCE = new AnimationMonades();
	
	/**List of the monades on the scene */
	private static ArrayList<Monade> listMonades;
	
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
