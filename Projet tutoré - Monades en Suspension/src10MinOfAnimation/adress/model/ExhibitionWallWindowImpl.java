package adress.model;

import java.io.IOException;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ExhibitionWallWindowImpl {
	
	public double width;
	public double height;
	
	public Group root;
	
	public AnimationImpl animation;
	
	/**
	 * 
	 * @param width
	 * @param height
	 * Create a virtual exhibition wall window with a configurable width and height
	 */
	public ExhibitionWallWindowImpl(Stage exhibitionWallStage, double width, double height) throws IOException{		
		root = new Group();
		exhibitionWallStage.setTitle("Monades en suspension");
		exhibitionWallStage.setResizable(false);
		Scene scene = new Scene(root, width, height);
		exhibitionWallStage.setScene(scene);
		exhibitionWallStage.setHeight(height);
		exhibitionWallStage.setWidth(width);
		
		this.animation = new AnimationImpl(this.root, 1);
		this.animation.run();
		
		exhibitionWallStage.show();
	}

}
