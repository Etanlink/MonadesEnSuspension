package adress;

import javafx.application.Application;
import javafx.stage.Stage;
import adress.model.CatchWindowImpl;

/**
 * Main creating a new catch window
 * @author Etanlink
 *
 */

//comment for commit test (florianmasson)
public class MainCatchWindow extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage secondaryStage) throws Exception {
		
		/* For test : instantiation of a catch animation window */
		CatchWindowImpl catchWindow = new CatchWindowImpl(secondaryStage);
	}

}
