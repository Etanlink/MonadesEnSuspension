package adress;
import javafx.animation.*;
import javafx.application.Application;
import javafx.event.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Random;

public class AppliTestProjet extends Application {
	private Stage primaryStage;
	private BorderPane rootLayout;
	public Group root = new Group();
	private static final Random r = new Random();
	public static final int SCENE_SIZE = 800;
	
	/* Pour une nouvelle fenetre */
	private Stage secondStage;
	
	public static void main(String[] args) throws Exception { launch(args); }
	public void start(final Stage stage) throws Exception {
		this.primaryStage=stage;
		initRootLayout();
		//addCircles();
		initUI();
		//launchAnimation();

	}

	private void initUI() {
		// TODO Auto-generated method stub

	}
	public void initRootLayout(){
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainMonadesEnSuspension.class.getResource("view/Border.fxml"));
			this.rootLayout = (BorderPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(root);

			//FXMLLoader loader2 = new FXMLLoader();
			//loader.setLocation(MainMonadesEnSuspension.class.getResource("view/animation.fxml"));
			//AnchorPane UIOverview = (AnchorPane) loader2.load();
			//Root.getChildren().add(UIOverview);
			this.primaryStage.setScene(scene);
			root.getChildren().add(rootLayout);
			this.primaryStage.show();
		}
		catch(IOException e){
			e.printStackTrace();
		}

	}
	public void addCircles(){
		try{
			final Group circles = new Group();

			final Timeline animation = new Timeline(
					new KeyFrame(Duration.seconds(0.5),

							new EventHandler<ActionEvent>() {
						@Override public void handle(ActionEvent actionEvent) {
							while (circles.getChildren().size() <= 3){
								int radius = 10 * r.nextInt(10);
								final Circle circ1 = new Circle(400,400, radius);
								circles.getChildren().add(circ1);
							}
							if(circles.getChildren().size() <= 10){
								int p = r.nextInt(100);
								int q = r.nextInt(100);
								if(q>=p)
								{
									int radius = 10 * r.nextInt(10);
									final Circle circ1 = new Circle(400,400, radius);
									circles.getChildren().add(circ1);
								}
							}
							for(Node circ1 : circles.getChildren()){
								if(circ1 instanceof Circle){
									TranslateTransition trans = new TranslateTransition(Duration.millis(/*r.nextInt(*/1000), circ1 );

									int x = r.nextInt(120);
									int y = 120-x;
									boolean p = r.nextBoolean();
									if(p==true) x = -x;
									p = r.nextBoolean();
									if(p==true) y = -y;

									trans.setByX(x);
									trans.setByY(y);
									trans.setInterpolator(Interpolator.LINEAR);
									trans.play();
								}
							}


						}
					})
					);
			animation.setCycleCount(Animation.INDEFINITE);
			animation.play();
			
			

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainMonadesEnSuspension.class.getResource("view/animation.fxml"));
			AnchorPane UIOverview = (AnchorPane) loader.load();
			// display the scene.
			circles.getChildren().add(UIOverview);
			//rootLayout.setCenter(circles);
			FXMLLoader loader2 = new FXMLLoader();
			loader2.setLocation(MainMonadesEnSuspension.class.getResource("view/control.fxml"));
			BorderPane UIOverview2 = (BorderPane) loader2.load();
			//Group ihm = new Group();
			//ihm.getChildren().add(UIOverview2);
			//UIOverview2.setCenter(circles);

			rootLayout.setCenter(circles);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Method which launch an animation in a new window
	 * This method will be used until we find a solution to fix the error with the UI.
	 */
	public void launchAnimation(){		
		/* On crée une scène de taille 800*600 pixels et de fond noir */
        Scene sceneAnimation = new Scene(this.root, 800, 600, Color.WHITE);
        this.secondStage.setTitle("Animation");
        this.secondStage.setScene(sceneAnimation);
        this.secondStage.show();
        addCircles2();
	}
	
	public void addCircles2() {
		final Group circles = new Group();
		this.root.getChildren().add(circles);

		final Timeline animation = new Timeline(
				new KeyFrame(Duration.seconds(0.5),

						new EventHandler<ActionEvent>() {
					@Override public void handle(ActionEvent actionEvent) {
						while (circles.getChildren().size() <= 3){
							int radius = 10 * r.nextInt(10);
							final Circle circ1 = new Circle(400,400, radius);
							circles.getChildren().add(circ1);
						}
						if(circles.getChildren().size() <= 10){
							int p = r.nextInt(100);
							int q = r.nextInt(100);
							if(q>=p)
							{
								int radius = 10 * r.nextInt(10);
								final Circle circ1 = new Circle(400,400, radius);
								circles.getChildren().add(circ1);
							}
						}
						for(Node circ1 : circles.getChildren()){
							if(circ1 instanceof Circle){
								TranslateTransition trans = new TranslateTransition(Duration.millis(/*r.nextInt(*/1000), circ1 );

								int x = r.nextInt(120);
								int y = 120-x;
								boolean p = r.nextBoolean();
								if(p==true) x = -x;
								p = r.nextBoolean();
								if(p==true) y = -y;

								trans.setByX(x);
								trans.setByY(y);
								trans.setInterpolator(Interpolator.LINEAR);
								trans.play();
							}
						}


					}
				})
				);
		animation.setCycleCount(Animation.INDEFINITE);
		animation.play();
		

	}
}