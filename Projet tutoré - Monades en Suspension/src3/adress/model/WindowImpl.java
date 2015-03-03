package adress.model;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Class binding stage, scene, animation and UI's different parts
 * @author Hugo
 *
 */
public class WindowImpl {

	private Stage primaryStage;

	//private BorderPane rootLayout;

	private Group root = new Group();

	private static final int SCENE_SIZE = 600;


	public WindowImpl(Stage primaryStage) throws IOException {

		super();
		primaryStage.setResizable(false);

		//MenuBar menuBar = loadMenuBar();
		MenuBar menuBar = manualMenuBar();

		//AnchorPane pane = new AnchorPane();

		/* Instantiation of the animation*/
		AnimationImpl animation = new AnimationImpl(root);

		this.primaryStage = primaryStage;

		Scene scene = new Scene(this.root, SCENE_SIZE, SCENE_SIZE);
		primaryStage.setScene(scene);
		animation.addCircles();
		/* the different parts of UI are bound AFTER the animation */
		/*									   ^^^^^			   */
		this.root.getChildren().add(menuBar);
		//this.root.getChildren().add(pane);
		this.primaryStage.show();
	}

	/**
	 * Creates a basic menuBar
	 * @return MenuBar : the menuBar of the window
	 */
	private MenuBar manualMenuBar() {
		final Menu menu1 = new Menu("File");
		final Menu menu2 = new Menu("Options");
		final Menu menu3 = new Menu("Help");

		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(menu1, menu2, menu3);
		menuBar.setMinWidth(SCENE_SIZE+10);
		return menuBar;
	}
	
	/**
	 * Creates a basic parametersPane
	 * @return parametersPane
	 */
	private Pane manualParametersPane() {
		final Pane parametersPane = new Pane();
		
		return parametersPane;
	}

	/**
	 * Loads the MenuBar of the UI
	 * @return MenuBar menubar
	 * @throws IOException
	 */
	private MenuBar loadMenuBar() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(WindowImpl.class.getResource("view/MenuBar.fxml"));
		MenuBar menubar = (MenuBar)loader.load();
		return menubar;
	}



}
