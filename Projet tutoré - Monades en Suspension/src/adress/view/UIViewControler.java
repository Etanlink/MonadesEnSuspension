package adress.view;

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
	
	public boolean yolo = true;

	
	private MainMonadesEnSuspension mainApp;
	
	
	
    public void setMainApp(MainMonadesEnSuspension mainApp) {
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
}
