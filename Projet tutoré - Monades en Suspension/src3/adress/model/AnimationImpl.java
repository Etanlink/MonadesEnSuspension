package adress.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

/**
 * USED FOR THREAD TESTING
 * Class generating and managing the animation
 * @author Hugo
 *
 */
public class AnimationImpl implements Runnable {

	private Group root;

	private final Group circles;

	private final Timeline animation;

	private ArrayList<AnimatedShapeThread> threadShapes = new ArrayList();

	private ArrayList<Shape> shapes;

	/* A boolean to detect a collision */
	boolean checkCollision = false;

	private static final Random r = new Random();

	public AnimationImpl(Group root) {
		super();
		this.root = root;
		this.circles = new Group();
		this.root.getChildren().add(circles);
		this.animation = buildTimeline();
	}

	public ArrayList<AnimatedShapeThread> getThreadShapes() {
		return threadShapes;
	}

	public Group getCircles() {
		return circles;
	}

	public Timeline getAnimation() {
		return this.animation;
	}
	/**
	 * builds a Timeline considering the different primary parameters
	 * @return animation : the overall timeline
	 */
	private Timeline buildTimeline() {
		final Timeline animation = new Timeline( new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				/* Generation of shapes */
				checkNumberOfShapes();
				//System.out.println("caca");

				/* Translation applied on each circle */
				/*
				 * for(Node circ1 : circles.getChildren()){


					/*if(
										circ1;
								{
									System.out.println("Cercle " + circles.getChildren().indexOf(circ1) + "se casse" );
									circles.getChildren().remove(circ1);
								}
					System.out.println("Cercle " + circles.getChildren().indexOf(circ1) + " x:" + ((ExtentedCircle) circ1).getX() + " y:" + ((ExtentedCircle) circ1).getY() );
					//checkShapeCollision((Shape) circ1);
				}*/
				}

		}));
		return animation;
	}
	

	/**
	 * creates a new AnimatedShapeThread and binds it with AnimationImpl
	 */
	private void createANewThread() {
		AnimatedShapeThread circThread = new AnimatedShapeThread();
		this.threadShapes.add(circThread);
		this.circles.getChildren().add(circThread.getShape());
		circThread.run();
	}
	
	/**
	 * generates shapes or not considering their number
	 */
	private void checkNumberOfShapes() {
		while (circles.getChildren().size() <= 3){
			createANewThread();
		}

		/* Control of the maximal parameter */
		if(circles.getChildren().size() <= 10){
			int p = r.nextInt(100);
			int q = r.nextInt(100);
			if(q>=p)
			{
				createANewThread();
			}
		}
	}

	/**
	 * @param
	 * method responsible of the overall animation
	 * @throws IOException
	 */
	public void animationWithParameters(double nbMinObjects, double percentageTinyObjects, 
			double percentageNormalObjects, double percentageBigObjects ) throws IOException {

		/* Creation of a group rootObjects which link the size subdivision on the root group */
		final Group rootObjects = new Group();
		/* Creation of the three different group objects which means the three different size of circles/monades */
		final Group tinyObjects = new Group();
		final Group normalObjects = new Group();
		final Group bigObjects = new Group();

		/* Add the three groups into the rootObjects group */
		rootObjects.getChildren().add(tinyObjects);
		rootObjects.getChildren().add(normalObjects);
		rootObjects.getChildren().add(bigObjects);

		/* Add the rootObjects group into the root group */
		this.root.getChildren().add(rootObjects);
		
		
		/* Instanciation of each objects group taking in parameters the different percentage and the nbMin */
		
		////////////////////////////////////////
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
						/*
						 * for(Node circ1 : circles.getChildren()){

							if(
										circ1;
								{
									System.out.println("Cercle " + circles.getChildren().indexOf(circ1) + "se casse" );
									circles.getChildren().remove(circ1);
								}
							//System.out.println("Cercle " + circles.getChildren().indexOf(circ1) + " x:" + ((ExtentedCircle) circ1).getX() + " y:" + ((ExtentedCircle) circ1).getY() );
						}
						 */
					}}));
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

	@Override
	public void run() {
		animation.setCycleCount(Animation.INDEFINITE);
		animation.play();
	}



}
