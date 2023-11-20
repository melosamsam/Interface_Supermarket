package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.image.Image;
import model.*;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.value.*;
import javafx.scene.text.*;
import java.text.*;

public class MMSlipController extends Controller<Membership> {
    @FXML private Text TotalCreditsTxt;
    @FXML private Text TotalExpenseTxt;
    @FXML private Text GasDeductionTxt;
    @FXML private Text PPCreditsTxt;
    @FXML private Text DollarAvailableTxt;
    @FXML private Text DeductionTxt;
    @FXML private Button CloseBtn;
    
    @FXML public Membership getMembership(){return model;}
    
    @FXML private void initialize(){
        //TotalCreditsTxt.setText(""+(getMembership().gettotalCredits()));
        TotalCreditsTxt.setText(formatted(getMembership().gettotalCredits()));
        TotalExpenseTxt.setText("$"+formatted(getMembership().getexpense()));
        GasDeductionTxt.setText(formatted(getMembership().getGasdeductionRate()));
        PPCreditsTxt.setText(formatted(getMembership().getPayPerCredit()));
        DollarAvailableTxt.setText("$"+formatted(getMembership().getDollarAvailable()));
        DeductionTxt.setText(formatted(getMembership().getdeductionRate()));
    }
    
    @FXML private void handleclose(ActionEvent e) throws Exception{
        Stage stage = (Stage)CloseBtn.getScene().getWindow();
        stage.close();
    }
    
    private String formatted(double money){
        DecimalFormatSymbols decim = DecimalFormatSymbols.getInstance();
        decim.setDecimalSeparator('.');
        return new DecimalFormat("#####0.00",decim).format(money);
    }
    


}
