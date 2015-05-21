package adress.model;

import java.io.IOException;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ExhibitionWallWindowImpl {
	
	public Group root;
	
	public ExhibitionAnimationImpl animation;
	
	/**
	 * @param exhibitionWallStage
	 * @param width
	 * @param height
	 * Create a virtual exhibition wall window with a configurable width and height
	 */
	public ExhibitionWallWindowImpl(Stage exhibitionWallStage, double width, double height) throws IOException{		
		
		/* Ratio configuration */
		width = width*2;
		height = height*2;
		
		root = new Group();
		exhibitionWallStage.setTitle("10 min of animation - Monades en suspension");
		exhibitionWallStage.setResizable(false);
		Scene scene = new Scene(root, width, height);
		exhibitionWallStage.setScene(scene);
		exhibitionWallStage.setHeight(height);
		exhibitionWallStage.setWidth(width);
		
		this.animation = new ExhibitionAnimationImpl(this.root, 2);
		this.animation.run();
		
		exhibitionWallStage.show();
	}

}
