package adress;

import java.io.IOException;

import javax.print.DocFlavor.URL;








import adress.model.AnimationMonades;
import adress.view.UIViewControler;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainMonadesEnSuspension extends Application {

	public Stage primaryStage;
	private BorderPane rootLayout;
	public Group Root = new Group();

	@Override 
	public void start(Stage primaryStage) {


		/*
        final Circle circ1 = new Circle(100, 100, 100);         
        circ1.setFill(Color.RED);
        final Pane root = new Pane(); 
        root.getChildren().setAll(circ1);         
        final Scene scene = new Scene(root, 800, 400);         
        primaryStage.setTitle("Test d'animation de translation"); 
        primaryStage.setScene(scene);
        primaryStage.show();
        final TranslateTransition translateAnimation = new TranslateTransition(Duration.seconds(2), circ1); 
        translateAnimation.setCycleCount(TranslateTransition.INDEFINITE); 
        translateAnimation.setAutoReverse(true); 
        translateAnimation.setByX(50); 
        translateAnimation.setByY(75); 
        translateAnimation.setInterpolator(Interpolator.LINEAR); 
        translateAnimation.play();
		 */
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Monades En Suspension");



		initRootLayout();



		showUIOverview();

		//AnimationMonades animMonades = AnimationMonades.getPhysicalEngine();
		//animMonades.setMainStage(this.primaryStage);
		//animMonades.createAnimation2();



	} 

	/**
	 * Initializes the root layout.
	 */
	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainMonadesEnSuspension.class.getResource("view/Border.fxml"));
			this.rootLayout = (BorderPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(Root);

			//FXMLLoader loader2 = new FXMLLoader();
			//loader.setLocation(MainMonadesEnSuspension.class.getResource("view/animation.fxml"));
			//AnchorPane UIOverview = (AnchorPane) loader2.load();
			//Root.getChildren().add(UIOverview);
			this.primaryStage.setScene(scene);
			Root.getChildren().add(rootLayout);
			this.primaryStage.show();


		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Shows the person overview inside the root layout.
	 */
	public void showUIOverview() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainMonadesEnSuspension.class.getResource("view/FUCK.fxml"));
			AnchorPane UIOverview = (AnchorPane) loader.load();

			// Set person overview into the center of root layout.
			this.rootLayout.setCenter(UIOverview);
			// Give the controller access to the main app.
			UIViewControler controller = loader.getController();
			//controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns the main stage.
	 * @return
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	public static void main(String[] args) {
		launch(args); 
	}

	public MainMonadesEnSuspension(){
	}
}
