package adress.model;

import java.io.IOException;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ExhibitionWallImpl {
	/**
	 * 
	 * @param stage
	 * @param root
	 * @param animation
	 * @param globalSC
	 * @param width
	 * @param height
	 * @throws IOException
	 */
	public ExhibitionWallImpl(Stage stage, Group root, AnimationImpl animation, double globalSC, double width, double height) throws IOException{		
		stage.setTitle("Monades en suspension");
		stage.setResizable(false);
		animation = new AnimationImpl(root, globalSC);
		Scene scene = new Scene(root, width, height);
		stage.setScene(scene);
		stage.setHeight(height);
		stage.setWidth(width);
		
		Button button = new Button("Test");
		
		root.getChildren().add(button);
		
		stage.show();
	}

}
