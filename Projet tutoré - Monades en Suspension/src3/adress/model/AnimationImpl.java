package adress.model;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
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

	private ArrayList<AnimatedImageThread> threadShapes = new ArrayList();

	private ArrayList<ImageView> shapes;

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

	public ArrayList<AnimatedImageThread> getThreadShapes() {
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

				handleMainThread();
			}
		}
				)
				);
		return animation;
	}
	
	/**
	 * content of the main TimeLine
	 */
	private void handleMainThread() {
		/* Generation of shapes */
		checkNumberOfShapes();
		
		/* Control on the exit */
		controlExit();
	}

	/**
	 * checks shape by shape if there is an exit or not
	 */
	private void controlExit() throws ConcurrentModificationException {
		for(Iterator<AnimatedImageThread> it = this.threadShapes.iterator(); it.hasNext();) {

			AnimatedImageThread thrcirc1 = it.next();
			/* The shape is removed if it is out of the scene */
			if(thrcirc1.isOutOfFrame())
			{
				//System.out.println("Cercle " + circles.getChildren().indexOf(circ1) + "se casse" );
				removeShapeFromScene(thrcirc1);
			}
			//System.out.println("Cercle " + circles.getChildren().indexOf(circ1) + " x:" + ((ExtentedCircle) circ1).getX() + " y:" + ((ExtentedCircle) circ1).getY() );
			//checkShapeCollision((Shape) circ1);
		}
	}

	/**
	 * creates a new AnimatedShapeThread and binds it with AnimationImpl
	 */
	private synchronized void createANewThread() {
		AnimatedImageThread circThread = new AnimatedImageThread();
		this.threadShapes.add(circThread);
		this.circles.getChildren().add(circThread.getNode());
		circThread.run();
	}

	/**
	 * generates shapes or not considering their number
	 */
	private void checkNumberOfShapes() {
		while (this.circles.getChildren().size() <= 3){
			createANewThread();
		}

		/* Control of the maximal parameter */
		if(this.circles.getChildren().size() <= 10){
			int p = this.r.nextInt(100);
			int q = this.r.nextInt(100);
			if(q>=p)
			{
				createANewThread();
			}
		}
	}

	/**
	 * Removes an AnimatedShapeThread from the list
	 * @param circ1 : the thread to remove
	 */
	private synchronized void removeShapeFromScene(AnimatedImageThread thrcirc1) {
		this.threadShapes.remove(thrcirc1);
		this.circles.getChildren().remove(thrcirc1.getNode());
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
	 * Adds dragListeners on ONE circle
	 * @param circ1 : the circle listened
	 */
	protected void setDragListeners(ImageView circ1) {
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

	@Override
	public void run() {
		animation.setCycleCount(Animation.INDEFINITE);
		animation.play();
	}
	
}
