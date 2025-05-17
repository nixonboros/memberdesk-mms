package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.*;

public class SuperMarketController extends Controller<SuperMarket> {
    @FXML private TextField nameTf;
    @FXML private TextField emailTf;
    @FXML private Button deleteBtn;
    @FXML private Button selectBtn;
    @FXML private Button slipBtn;
    @FXML private TableView<Membership> infoTv;

    public final SuperMarket getSuperMarket() { return model; }

    @FXML private void initialize() {
        infoTv.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY); // sets tableview columns equal width

        // disables 3 buttons if no cell is selected
        deleteBtn.disableProperty().bind(infoTv.getSelectionModel().selectedItemProperty().isNull());
        selectBtn.disableProperty().bind(infoTv.getSelectionModel().selectedItemProperty().isNull());
        slipBtn.disableProperty().bind(infoTv.getSelectionModel().selectedItemProperty().isNull());

        // name and email filters
        nameTf.textProperty().addListener((o, oldtext, newtext) -> getSuperMarket().filterList(newtext, newtext));
        emailTf.textProperty().addListener((o, oldtext, newtext) -> getSuperMarket().filterList(newtext, newtext));
    }

    public final Membership getSelectedMembership() {
        return infoTv.getSelectionModel().getSelectedItem();
    }

    @FXML private void handleAdd(ActionEvent event) throws Exception {
        Membership newMembership = new Membership("", "", "", "", "", Double.parseDouble("0.0"));
        newMembership.setSuperMarket(getSuperMarket());

        Stage stageAdd = new Stage();
        stageAdd.getIcons().add(new Image("view/edit.png"));
        ViewLoader.showStage(newMembership, "/view/Membership.fxml", "Adding New Membership", stageAdd);
    }

    @FXML private void handleDelete(ActionEvent event) throws Exception {
        getSuperMarket().removeMembership((Membership) infoTv.getSelectionModel().getSelectedItem());
        infoTv.getSelectionModel().clearSelection();
    }

    @FXML private void handleSelect(ActionEvent event) throws Exception {
        Stage stageSelect = new Stage();
        stageSelect.getIcons().add(new Image("view/edit.png"));
        ViewLoader.showStage(getSelectedMembership(), "/view/Membership.fxml", "Accessing File: "+getSelectedMembership().getName(), stageSelect);
        infoTv.getSelectionModel().clearSelection();
    }

    @FXML private void handleSlip(ActionEvent event) throws Exception {
        Stage stageSlip = new Stage();
        stageSlip.getIcons().add(new Image("view/edit.png"));
        ViewLoader.showStage(new MMSreport(new Membership(getSelectedMembership().getName(), getSelectedMembership().getEmail(), getSelectedMembership().getPhone(), getSelectedMembership().getAddress(), getSelectedMembership().getID(), getSelectedMembership().getexpense())), "/view/slip.fxml", getSelectedMembership().getName()+" SLIP Report", stageSlip);
        infoTv.getSelectionModel().clearSelection();
    }

    @FXML private void handleReport(ActionEvent event) throws Exception {
        Stage stageReport = new Stage();
        stageReport.getIcons().add(new Image("view/uts.jpeg"));
        ViewLoader.showStage(new MMS(getSuperMarket()), "/view/mms.fxml", "MMS Report", stageReport);
    }
    @FXML private void handleClose(ActionEvent event) throws Exception {
        stage.close();
    }
}
