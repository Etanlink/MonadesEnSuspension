package adress.model;

import java.io.IOException;
import java.util.Random;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

/**
 * USED FOR THREAD TESTING
 * Class generating and managing the animation
 * @author Hugo
 *
 */
public class CopyOfAnimationImpl {

	private Group root;

	private static final Random r = new Random();

	public CopyOfAnimationImpl(Group root) {
		super();
		this.root = root;
	}

	/**
	 * method responsible of the overall animation
	 * @throws IOException
	 */
	public void addCircles() throws IOException {
		final Group circles = new Group();
		this.root.getChildren().add(circles);

		final Timeline animation = new Timeline(
				new KeyFrame(Duration.millis(3000),
		new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				
		while (circles.getChildren().size() <= 3){
			AnimatedShapeThread circThread = new AnimatedShapeThread();
			circles.getChildren().add(circThread.getShape());
			circThread.run();
		}

		/* Control of the maximal parameter */
		if(circles.getChildren().size() <= 10){	
			int p = r.nextInt(100);
			int q = r.nextInt(100);
			if(q>=p)
			{
				AnimatedShapeThread circThread = new AnimatedShapeThread();
				circles.getChildren().add(circThread.getShape());
				circThread.run();
			}
		}

		/* Translation applied on each circle */
		for(Node circ1 : circles.getChildren()){

			/*if(
										circ1;
								{
									System.out.println("Cercle " + circles.getChildren().indexOf(circ1) + "se casse" );
									circles.getChildren().remove(circ1);
								}*/
			System.out.println("Cercle " + circles.getChildren().indexOf(circ1) + " x:" + ((ExtentedCircle) circ1).getX() + " y:" + ((ExtentedCircle) circ1).getY() );
		}}}));
		animation.setCycleCount(Animation.INDEFINITE);
		animation.play();
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
