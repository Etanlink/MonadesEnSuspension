package view;

import Main.MainMonadesEnSuspension;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;


public class UIViewControler {

	
	@FXML
	private Button BoutonBouger;
	@FXML
	public Circle cercle;
	
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
    private void handleBougerCercle(){
    	this.cercle.setRadius(50);
    }
}
