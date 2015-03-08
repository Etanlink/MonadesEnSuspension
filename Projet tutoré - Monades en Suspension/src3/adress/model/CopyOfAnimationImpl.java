package adress.model;

import java.io.IOException;
import java.util.ArrayList;
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

	final Group circles = new Group();
	
	private ArrayList<Shape> shapes;
	
	/* A boolean to detect a collision */
	boolean checkCollision = false;
	
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
	
	/**
	 * Check a collision between shapes
	 * @param a shape : allow to work for a circle and later for a monade
	 */
	public void checkShapeCollision(Shape shape){
		Color shapeColor = (Color) shape.getFill();
		/* Testing the intersection for each shapes in the ArrayList */
		for(Shape shapeToTest : shapes){
			if(shapeToTest != shape){
				Shape intersect = Shape.intersect(shapeToTest, shape);
				/* Test if the two shapes are inside each other */
				if(intersect.getBoundsInLocal().getWidth() != -1){
					checkCollision = true;
				}
			}
		}
		/* When a collision is detected, the current shape become red */
		if(checkCollision = true){
			shape.setFill(Color.RED);			
		}
		else{
			/* Else, the shape keeps is previous color */
			shape.setFill(shapeColor);
		}
	}
	
}
