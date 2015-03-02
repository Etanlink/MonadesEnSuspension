package adress.view;

import adress.AppliTestProjet;
import adress.MainMonadesEnSuspension;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;


public class UIViewControler {


	@FXML
	private Button BoutonAnimation;

	@FXML
	private Button BoutonPause;

	@FXML
	public Circle cercle;

	@FXML
	private Button BoutonCapture;

	@FXML
	private Button BoutonDossier;
	
	@FXML
	private Button LancerAnim;

	public boolean yolo = true;


	private AppliTestProjet mainApp;



	public void setMainApp(AppliTestProjet mainApp) {
		this.mainApp = mainApp;

	}

	public UIViewControler(){
	}

	@FXML
	private void initialize() {
	}

	@FXML
	private void handlerAnimerCercle(){
		if (this.yolo==true){
			this.cercle.setRadius(20);
			this.yolo=false;
		}
		else{
			this.cercle.setRadius(50);
			this.yolo=true;
		}

	}

	@FXML
	private void handlerPauseAnimation(){

	}

	@FXML
	private void handlerCaptureEcran(){

	}
	@FXML
	private void handlerChoisirDossier(){
	}
	
	@FXML
	/**
	 * On click, launching the animation in a new window
	 */
	private void handlerButtonLaunchAnimation(){
		this.mainApp.launchAnimation();
		
	}
}
