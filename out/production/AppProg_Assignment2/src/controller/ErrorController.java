package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.LinkedList;

public class ErrorController extends Controller<Validator>{
    @FXML private Label incorrectPattern;

    public final Validator getValidator() { return model; }

    @FXML private void initialize() {
        LinkedList<String> errors = getValidator().errors();

        incorrectPattern.setText(incorrectPattern.getText()+errors.get(0));
        for (int i=1; i<errors.size(); i++) {
            incorrectPattern.setText(incorrectPattern.getText() + errors.get(i));
        }
    }

    @FXML private void handleClose(ActionEvent event) throws Exception {
        stage.close();
    }
}
