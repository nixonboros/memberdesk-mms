package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Session;

public class SessionController extends Controller<Session> {
    @FXML private void handleLoginMenu(ActionEvent event) throws Exception {
        Stage stageLogin = new Stage();
        stageLogin.getIcons().add(new Image("view/book.png"));
    	ViewLoader.showStage(new Session(), "/view/MMSlogin.fxml", "Sign In", stageLogin);
    }
    
    @FXML private void handleExit(ActionEvent event) throws Exception {
    	System.exit(0);
    }
}
