package adress.model;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Slider;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * Class binding stage, scene, animation and UI's different parts
 * @author Hugo & Etanlink
 *
 */
public class WindowImpl {

	private Stage primaryStage;

	//private BorderPane rootLayout;

	private Group root = new Group();

	static final int SCENE_SIZE = 600;
	
	static final int W_SCENE_SIZE = 800;
	static final int H_SCENE_SIZE = 600;
	
	private static final int PARAMETERS_PANE_SIZE = 620;

	@FXML
	public void saveAsPng() {
	    WritableImage image = root.snapshot(new SnapshotParameters(), null);

	    // TODO: probably use a file chooser here
	    File file = new File("chart.png");

	    try {
	        ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
	    } catch (IOException e) {
	        // TODO: handle exception here
	    }
	}

	public WindowImpl(Stage primaryStage) throws IOException {

		super();
		primaryStage.setTitle("Monades en suspension");
		primaryStage.setResizable(false);

		//MenuBar menuBar = loadMenuBar();
		MenuBar menuBar = manualMenuBar();
		
		VBox parametersVBox = manualParametersVBox();

		/* Instantiation of the animation*/
		CopyOfAnimationImpl animation = new CopyOfAnimationImpl(root);

		this.primaryStage = primaryStage;

		Scene scene = new Scene(this.root, W_SCENE_SIZE, H_SCENE_SIZE);
		primaryStage.setScene(scene);
		animation.addCircles();
		/* the different parts of UI are bound AFTER the animation */
		/*									   ^^^^^			   */
		this.root.getChildren().add(parametersVBox);
		this.root.getChildren().add(menuBar);
		this.primaryStage.show();
	}

	/**
	 * Creates a basic menuBar
	 * @return MenuBar : the menuBar of the window
	 */
	private MenuBar manualMenuBar() {
		final Menu helpMenuItem = new Menu("Aide");		
		final Menu aboutMenuItem = new Menu("À propos");

		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(helpMenuItem, aboutMenuItem);
		menuBar.setMinWidth(W_SCENE_SIZE+10);
		return menuBar;
	}
	
	/**
	 * Creates a basic parametersPane
	 * @return parametersPane
	 * @throws IOException 
	 */
	private VBox manualParametersVBox() throws IOException {
		
		final VBox parametersVBox = new VBox();
		parametersVBox.setPrefSize(220, PARAMETERS_PANE_SIZE);
		parametersVBox.setStyle("-fx-background-color: #f5f5f5;");
		
		/* Add of a VBox title */
		Text VBoxTitle = new Text("Paramètres");
		VBoxTitle.setFont(Font.font("System", FontWeight.SEMI_BOLD, 16));
		parametersVBox.getChildren().add(VBoxTitle);
		
		/* Align all of the VBox components to CENTER_LEFT */
		parametersVBox.setAlignment(Pos.BASELINE_CENTER);
		/* Addition of spacing between the VBox Components */
		parametersVBox.setSpacing(20);
		//parametersVBox.setMargin((Node) parametersVBox.getChildren(),new Insets(20));
		
		/* Add of the different controllers */
		Label LabelNBMinObjects = new Label("Nombre minimum de Monades");
		Slider NbMinObjects = new Slider(3, 10, 3);
		NbMinObjects.setShowTickLabels(true);
		
		Label LabelTinyObjectsPercentage = new Label("Pourcentage de petites Monades");
		Slider TinyObjectsPercentage = new Slider(0, 100, 0);//respectively : min, max, beginValue
		TinyObjectsPercentage.setShowTickLabels(true);
		
		Label LabelNormalObjectsPercentage = new Label("Pourcentage de moyennes de Monades");
		Slider NormalObjectsPercentage = new Slider(0, 100, 0);//respectively : min, max, beginValue;
		NormalObjectsPercentage.setShowTickLabels(true);
		
		Label LabelBigObjectsPercentage = new Label("Pourcentage de grandes Monades");
		Slider BigObjectsPercentage = new Slider(0, 100, 0);//respectively : min, max, beginValue;
		BigObjectsPercentage.setShowTickLabels(true);
		
		Button launchAnimationButton = new Button();
		launchAnimationButton.setText("Lancer l'animation");
		
		Button pauseAnimationButton = new Button();
		pauseAnimationButton.setText("Mettre en pause l'animation");
		
		Button snapshotAnimationButton = new Button();
		snapshotAnimationButton.setText("Capturer l'animation en cours");
		
		snapshotAnimationButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                saveAsPng();
            }
        });
		
		/* Add of the controllers to the VBox */
		parametersVBox.getChildren().add(LabelNBMinObjects);
		parametersVBox.getChildren().add(NbMinObjects);
		
		parametersVBox.getChildren().add(LabelTinyObjectsPercentage);
		parametersVBox.getChildren().add(TinyObjectsPercentage);
		
		parametersVBox.getChildren().add(LabelNormalObjectsPercentage);
		parametersVBox.getChildren().add(NormalObjectsPercentage);
		
		parametersVBox.getChildren().add(LabelBigObjectsPercentage);
		parametersVBox.getChildren().add(BigObjectsPercentage);
		
		parametersVBox.getChildren().add(launchAnimationButton);
		
		parametersVBox.getChildren().add(pauseAnimationButton);
		
		parametersVBox.getChildren().add(snapshotAnimationButton);
		
		return parametersVBox;
	}


	/**
	 * Loads the MenuBar of the UI
	 * @return MenuBar menubar
	 * @throws IOException
	 */
	/*private MenuBar loadMenuBar() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(WindowImpl.class.getResource("view/MenuBar.fxml"));
		MenuBar menubar = (MenuBar)loader.load();
		return menubar;
	}*/



}
