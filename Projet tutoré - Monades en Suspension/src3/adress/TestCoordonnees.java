package adress;

import java.util.Random;
import adress.model.Delta;
import adress.model.ExtentedCircle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;


public class TestCoordonnees extends Application {
	
	private static final Random r = new Random();
	
	public static final double SCENE_SIZE = 800;
	
	

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(final Stage stage) throws Exception {
		final Group circles = new Group();
		
		int radius = 10 * r.nextInt(10);
		final ExtentedCircle circ1 = new ExtentedCircle(400,400, radius);
		circles.getChildren().add(circ1);
		System.out.println("Cercle : " + circ1.getX()+", " + circ1.getY());
		setDragListeners(circ1);
		
		Animation animation = new Timeline(
				new KeyFrame(Duration.millis(100),

						new EventHandler<ActionEvent>() {
					
					double x1 = circ1.getX();
					double y1 = circ1.getX();
					double x2 = circ1.getX();
					double y2 = circ1.getX();

					@Override
					public void handle(ActionEvent arg0) {
						x1 = circ1.getX();
						y1 = circ1.getX();
						if( (x1 != x2) || (y1 != y2)){
							System.out.println("Cercle : " + circ1.getX()+", " + circ1.getY());
						}
						x2 = circ1.getX();
						y2 = circ1.getX();
						}
						
						
				}) );
		animation.setCycleCount(Animation.INDEFINITE);
		animation.play();

		
		// display the scene.
		stage.setScene(new Scene(circles, SCENE_SIZE, SCENE_SIZE, Color.CORNSILK));
		stage.show();
		
	}
	
	/**
	 * Adds dragListeners on ONE circle
	 * @param circ1 : the circle listened
	 */
	protected void setDragListeners(ExtentedCircle circ1) {
		final Delta dragDelta = new Delta();

		circ1.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent mouseEvent) {
				// record a delta distance for the drag and drop operation.
				dragDelta.setX((double)(circ1.getLayoutX() - mouseEvent.getSceneX()));
				dragDelta.setY((double)(circ1.getLayoutY() - mouseEvent.getSceneY()));
				circ1.setCursor(Cursor.NONE);
			}
		});

		circ1.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent mouseEvent) {
				circ1.setCursor(Cursor.HAND);
				circ1.setX(mouseEvent.getSceneX());
				circ1.setY(mouseEvent.getSceneY());
			}
		});

		circ1.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent mouseEvent) {
				circ1.setLayoutX(mouseEvent.getSceneX() + dragDelta.getX());
				circ1.setLayoutY(mouseEvent.getSceneY() + dragDelta.getY());

				circ1.setX(mouseEvent.getSceneX());
				circ1.setY(mouseEvent.getSceneY());
			}
		});

	}

}
