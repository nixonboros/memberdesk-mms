package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.MMSreport;

public class MMSlipController extends Controller<MMSreport>{
    @FXML private Label totalcreditsText;
    @FXML private Label totalexpenseText;
    @FXML private Label gasdeductionrateText;
    @FXML private Label paypercreditText;
    @FXML private Label dollaravailableText;
    @FXML private Label deductionrateText;

    public final MMSreport getMMSlip() { return model; }

    @FXML private void initialize() {
        // membership slip info formatting
        totalcreditsText.setText(String.format("%.2f", getMMSlip().gettotalCredits()));
        totalexpenseText.setText(String.format("$%.2f", getMMSlip().getexpense()));
        gasdeductionrateText.setText(String.format("%.2f", getMMSlip().getGasdeductionRate()));
        paypercreditText.setText(String.format("%.2f", getMMSlip().getPayPerCredit()));
        dollaravailableText.setText(String.format("$%.2f", getMMSlip().getDollarAvailable()));
        deductionrateText.setText(String.format("%.2f", getMMSlip().getdeductionRate()));
    }

    @FXML private void handleClose(ActionEvent event) throws Exception {
        stage.close();
    }
}
