package controller;


import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
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


public class MMSController extends Controller<SuperMarket> {
    @FXML private TableView Tablereport;
    @FXML private TableColumn TableCol;
    @FXML private Text TotExpTxt;
    @FXML private Text TotCredits;
    @FXML private Text AvgGasDeducTxt;
    @FXML private Text AvgDeducTxt;
    @FXML private Text AvgPPCreditTxt;
    @FXML private Text TotDollarAvailableTxt;
    @FXML private Button CloseBtn;
    
    
    
    @FXML public SuperMarket getSupermarket(){return model;}
    
    @FXML private void initialize(){
    Tablereport.setItems(getSupermarket().getMemberships());
    
    double Expense=0;
    double totalCredits=0;
    double DollarAvailable=0;
    double PayPerCredit=0;
    double deductionRate= 0;
    double GasdeductionRate=0;
    int i=0;

        for(Membership membership : model.getMemberships()){
            Expense+=membership.getexpense();
            totalCredits+=membership.gettotalCredits();
            DollarAvailable+=membership.getDollarAvailable();
            PayPerCredit+=membership.getPayPerCredit();
            deductionRate+=membership.getdeductionRate();
            GasdeductionRate+=membership.getGasdeductionRate();
            i++;
        }
            
        PayPerCredit/=i;
        deductionRate/=i;
        GasdeductionRate/=i;
        
        TotExpTxt.setText("$"+formatted(Expense));
        TotCredits.setText(formatted(totalCredits));
        AvgGasDeducTxt.setText(formatted(GasdeductionRate));
        AvgDeducTxt.setText(formatted(deductionRate));
        AvgPPCreditTxt.setText(formatted(PayPerCredit));
        TotDollarAvailableTxt.setText("$"+formatted(DollarAvailable));
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
