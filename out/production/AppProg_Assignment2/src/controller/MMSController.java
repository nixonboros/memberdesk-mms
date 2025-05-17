package controller;


import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.MMS;
import model.Membership;


public class MMSController extends Controller<MMS> {
    @FXML private TableView infoTv;
    @FXML private Label totalexpenseText;
    @FXML private Label avggasdeductionrateText;
    @FXML private Label avgpaypercreditText;
    @FXML private Label totalcreditsText;
    @FXML private Label avgdeductionrateText;
    @FXML private Label totaldollaravailableText;
    @FXML private TableColumn<Membership, String> expenseClm;
    @FXML private TableColumn<Membership, String> creditsClm;
    @FXML private TableColumn<Membership, String> gasdeductionrateClm;
    @FXML private TableColumn<Membership, String> deductionrateClm;
    @FXML private TableColumn<Membership, String> paypercreditClm;
    @FXML private TableColumn<Membership, String> dollaravailableClm;

    public final MMS getMMS() { return model; }

    @FXML private void initialize() {
        infoTv.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY); // sets tableview columns equal width

        // tableview column formatting
        expenseClm.setCellValueFactory(cellData -> cellData.getValue().expenseProperty().asString("$%.2f"));
        creditsClm.setCellValueFactory(cellData -> cellData.getValue().totalCreditsProperty().asString("%.2f"));
        gasdeductionrateClm.setCellValueFactory(cellData -> cellData.getValue().GasdeductionRateProperty().asString("%.2f"));
        deductionrateClm.setCellValueFactory(cellData -> cellData.getValue().deductionRateProperty().asString("%.2f"));
        paypercreditClm.setCellValueFactory(cellData -> cellData.getValue().payPerCreditProperty().asString("%.2f"));
        dollaravailableClm.setCellValueFactory(cellData -> cellData.getValue().DollarAvailableProperty().asString("$%d.00"));

        // total and avg info formatting
        totalexpenseText.setText(String.format("$%.2f", getMMS().getTotalExpense()));
        avggasdeductionrateText.setText(String.format("%.2f", getMMS().getAvgGasdeductionRate()));
        avgpaypercreditText.setText(String.format("%.2f", getMMS().getAvgPayPerCredit()));
        totalcreditsText.setText(String.format("%.2f", getMMS().getTotalCredits()));
        avgdeductionrateText.setText(String.format("%.2f", getMMS().getAvgdeductionRate()));
        totaldollaravailableText.setText(String.format("$%.2f", getMMS().getTotalDollarAvailable()));
    }

    @FXML private void handleClose(ActionEvent event) throws Exception {
        stage.close();
    }
}
