package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Session;
import model.SuperMarket;

public class MMSLoginController extends Controller<Session> {
    @FXML private TextField emailTf;
    @FXML private PasswordField passwordTf;
    @FXML private Label incorrectMsg;

	public final Session getSession() { return model; }
    
    @FXML private void handleLoginCheck(ActionEvent event) throws Exception {
        // checks if email and pass input combination matches any admin credentials
    	if (getSession().getSuperMarket(emailTf.getText(), passwordTf.getText()) != null) {
    	    Stage stageSuperMarket = new Stage();
            stageSuperMarket.getIcons().add(new Image("view/SuperMarket.png"));
			ViewLoader.showStage(new SuperMarket(), "/view/SuperMarket.fxml", "Session Admin: "+getSession().getSuperMarket(emailTf.getText(), passwordTf.getText()).getName(), stageSuperMarket);
            stage.close();
    	}
    	else {
    		incorrectMsg.setText("Incorrect login details!");
    	}
    }

    @FXML private void handleExit(ActionEvent event) throws Exception {
    	stage.close();
    }
}

