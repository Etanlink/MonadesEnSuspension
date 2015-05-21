package adress;

import adress.model.HBoxWindowImpl;
import adress.model.WindowImpl2;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp2 extends Application{

	  public Stage primaryStage;
	  public WindowImpl2 Window;/*
	  public HBoxWindowImpl Window;*/
	    
		public static void main(String[] args) {
			launch(args);
		}

		@Override
		public void start(Stage primaryStage) throws Exception {
			/* Instantiation of a new window */
			this.primaryStage = primaryStage ;
			WindowImpl2 window = new WindowImpl2();
			/*HBoxWindowImpl window = new HBoxWindowImpl();*/
			this.Window = window;
			this.Window.primaryStageInitialisation(primaryStage);
			this.Window.setMainApp(this);
		}
}
