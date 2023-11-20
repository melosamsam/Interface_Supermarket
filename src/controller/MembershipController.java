package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import java.util.LinkedList;
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


public class MembershipController extends Controller<Membership>  {
    @FXML private TextField NameTf;
    @FXML private TextField EmailTf;
    @FXML private TextField PhoneTf;
    @FXML private TextField AddressTf;
    @FXML private TextField IDTf;
    @FXML private TextField ExpenseTf;
    @FXML private Text TypeTxt;
    @FXML private Button AddBtn;
    @FXML private Button UpdateBtn;
    @FXML private Button CloseBtn;
    
    @FXML public Membership getMembership(){return model;}
    
    @FXML private void initialize(){
        NameTf.setText(model.getName());
        EmailTf.setText(getMembership().getEmail());
        PhoneTf.setText(getMembership().getPhone());
        AddressTf.setText(getMembership().getAddress());
        IDTf.setText(getMembership().getID());
        ExpenseTf.setText(""+getMembership().getexpense());
        TypeTxt.setText(getMembership().getType());
        if(getMembership().getName().equals("")){
            UpdateBtn.setDisable(true);
        }
        else{
            AddBtn.setDisable(true);
        }
    }
    
    @FXML private void handleadd(ActionEvent e) throws Exception{
        Validator v = new Validator();
        String name= NameTf.getText();
        String email= EmailTf.getText();
        String phone= PhoneTf.getText();
        String address= AddressTf.getText();
        String ID = IDTf.getText();
        double expense = Double.parseDouble(ExpenseTf.getText());
        if(!v.isValid(name, email, phone, address, ID, expense)){
            v.generateErrors(name, email, phone, address, ID, expense);
            Stage stage6 = new Stage();
            stage6.getIcons().add(new Image("view/error.png"));
            stage6.setX(ViewLoader.X);
            stage6.setY(ViewLoader.Y);
            ViewLoader.showStage(v, "/view/error.fxml", "Input Exceptions", stage6);
        }
        else{
            getMembership().updateDetails(name, email, phone, address, ID, expense);
            Stage stage = (Stage)CloseBtn.getScene().getWindow();
            stage.close();
        }
        
    }
    
    @FXML private void handleupdate(ActionEvent e) throws Exception{
        Validator v = new Validator();
        String name= NameTf.getText();
        String email= EmailTf.getText();
        String phone= PhoneTf.getText();
        String address= AddressTf.getText();
        String ID = IDTf.getText();
        double expense = Double.parseDouble(ExpenseTf.getText());
        if(!v.isValid(name, email, phone, address, ID, expense)){
            v.generateErrors(name, email, phone, address, ID, expense);
            Stage stage6 = new Stage();
            stage6.getIcons().add(new Image("view/error.png"));
            stage6.setX(ViewLoader.X);
            stage6.setY(ViewLoader.Y);
            ViewLoader.showStage(v, "/view/error.fxml", "Input Exceptions", stage6);
        }
        else{
            getMembership().updateDetails(name, email, phone, address, ID, expense);
            Stage stage = (Stage)CloseBtn.getScene().getWindow();
            stage.close();
        }
    }
    
    @FXML private void handleclose(ActionEvent e) throws Exception{
        Validator v = new Validator();
        String name= NameTf.getText();
        String email= EmailTf.getText();
        String phone= PhoneTf.getText();
        String address= AddressTf.getText();
        String ID = IDTf.getText();
        double expense = Double.parseDouble(ExpenseTf.getText());
        if(!v.isValid(name, email, phone, address, ID, expense)){
            model.getSuperMarket().removeMembership(model);
        }
        Stage stage = (Stage)CloseBtn.getScene().getWindow();
        stage.close();
    }
    
    
    

}
