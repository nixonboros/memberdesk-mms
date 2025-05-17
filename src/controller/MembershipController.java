package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Membership;


public class MembershipController extends Controller<Membership> {
    @FXML private TextField nameTf;
    @FXML private TextField emailTf;
    @FXML private TextField phoneTf;
    @FXML private TextField addressTf;
    @FXML private TextField idTf;
    @FXML private TextField expenseTf;
    @FXML private Button addBtn;
    @FXML private Button updateBtn;
    @FXML private Label typeTxt;

    public final Membership getMembership() { return model; }

    @FXML private void initialize() {
        // if update btn is pressed > fields will be set to selected membership
        nameTf.setText(getMembership().getName());
        emailTf.setText(getMembership().getEmail());
        phoneTf.setText(getMembership().getPhone());
        addressTf.setText(getMembership().getAddress());
        idTf.setText(getMembership().getID());
        expenseTf.setText(String.valueOf(getMembership().getexpense()));
        typeTxt.setText((getMembership().getType()));

        // checks if add or select has been pressed
        if (nameTf.getText().equals("")) {
            updateBtn.setDisable(true);
        }
        else {
            addBtn.setDisable(true);
        }
    }

    @FXML private void handleAdd(ActionEvent event) throws Exception {
        Validator Validator = new Validator();

        if (Validator.isValid(nameTf.getText(), emailTf.getText(), phoneTf.getText(), addressTf.getText(), idTf.getText(), Double.parseDouble(expenseTf.getText()))) {
            getMembership().getSuperMarket().addMembership(new Membership(nameTf.getText(), emailTf.getText(), phoneTf.getText(), addressTf.getText(), idTf.getText(), Double.parseDouble(expenseTf.getText())));
            stage.close();
        }
        else {
            Validator.generateErrors(nameTf.getText(), emailTf.getText(), phoneTf.getText(), addressTf.getText(), idTf.getText(), Double.parseDouble(expenseTf.getText()));
            Stage stageError = new Stage();
            stageError.getIcons().add(new Image("view/error.png"));
            ViewLoader.showStage(Validator, "/view/error.fxml", "Input Exceptions", stageError);
        }
    }

    @FXML private void handleUpdate(ActionEvent event) throws Exception {
        Validator Validator = new Validator();

        if (Validator.isValid(nameTf.getText(), emailTf.getText(), phoneTf.getText(), addressTf.getText(), idTf.getText(), Double.parseDouble(expenseTf.getText()))) {
            getMembership().updateDetails(nameTf.getText(), emailTf.getText(), phoneTf.getText(), addressTf.getText(), idTf.getText(), Double.parseDouble(expenseTf.getText()));
            stage.close();
        }
        else {
            Validator.generateErrors(nameTf.getText(), emailTf.getText(), phoneTf.getText(), addressTf.getText(), idTf.getText(), Double.parseDouble(expenseTf.getText()));
            Stage stageError = new Stage();
            stageError.getIcons().add(new Image("view/error.png"));
            ViewLoader.showStage(Validator, "/view/error.fxml", "Input Exceptions", stageError);
        }
    }

    @FXML private void handleClose(ActionEvent event) throws Exception {
        stage.close();
    }
}
