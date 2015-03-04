package adress.model;

import java.io.IOException;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Class creating a new window of the animation catch's
 * @author Etanlink
 *
 */
public class CatchWindowImpl {
	
	private Stage secondaryStage;
	
	private Group rootCatchWindow = new Group();
	
	static final int W_SCENE_SIZE = 800;
	static final int H_SCENE_SIZE = 600;
	
	public CatchWindowImpl(Stage secondaryStage) throws IOException {
		
		secondaryStage.setTitle("Capture de l'animation");
		secondaryStage.setResizable(false);
		this.secondaryStage = secondaryStage;
		
		Scene catchWindowScene = new Scene(this.rootCatchWindow, W_SCENE_SIZE, H_SCENE_SIZE);
		secondaryStage.setScene(catchWindowScene);
		
		this.secondaryStage.show();
	}

}
