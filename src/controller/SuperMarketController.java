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



public class SuperMarketController extends Controller<SuperMarket>  
{
    @FXML private TableView<Membership> membershipTv;
    @FXML private Button DeleteBtn;
    @FXML private Button SelectBtn;
    @FXML private Button SLIPBtn;
    @FXML private Button CloseBtn;
    @FXML private TextField FilternameTf;
    @FXML private TextField FilteremailTf;
    
    @FXML public SuperMarket getSupermarket(){return model;}
    @FXML public Membership getmembership() {return membershipTv.getSelectionModel().getSelectedItem();}
    @FXML private void initialize() {
        membershipTv.setItems(getSupermarket().getMemberships());
        membershipTv.getSelectionModel().selectedIndexProperty().addListener(
                (o, oldAcct, newAcct) -> DeleteBtn. setDisable(getmembership() == null));
        membershipTv.getSelectionModel().selectedIndexProperty().addListener(
                (o, oldAcct, newAcct) -> SelectBtn. setDisable(getmembership() == null));
        membershipTv.getSelectionModel().selectedIndexProperty().addListener(
                (o, oldAcct, newAcct) -> SLIPBtn. setDisable(getmembership() == null));
        membershipTv.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        FilternameTf.textProperty().addListener((o, oldText, newText) -> getSupermarket().filterList(FilternameTf.getText(),"*" ));
        //getSupermarket().filterList(FilternameTf.getText(), "")
        FilteremailTf.textProperty().addListener((o, oldText, newText) -> getSupermarket().filterList("*", FilteremailTf.getText()));
        //getSupermarket().filterList("", FilteremailTf.getText())
        
    }
    
    @FXML private void handleselect(ActionEvent event) throws Exception {
        Membership m = getmembership();
        m.setSuperMarket(model);
        Stage stage4 = new Stage();
        stage4.getIcons().add(new Image("view/edit.png"));
        stage4.setX(ViewLoader.X);
        stage4.setY(ViewLoader.Y);
        ViewLoader.showStage(m, "/view/Membership.fxml", "Accessing File: "+getmembership().getName(), stage4);
        
    }
    
    @FXML private void handledelete(ActionEvent event) throws Exception {
        model.removeMembership(membershipTv.getSelectionModel().getSelectedItem());
        DeleteBtn.disableProperty();
        SelectBtn.disableProperty();
        SLIPBtn.disableProperty();
        
    }
    
    @FXML private void handleclose(ActionEvent e) throws Exception{
        Stage stage = (Stage)CloseBtn.getScene().getWindow();
        stage.close();
    }
    
    @FXML private void handleadd(ActionEvent e) throws Exception{
        Membership m = new Membership("","","","","",0.0);
        getSupermarket().addMembership(m);
        m.setSuperMarket(model);
        Stage stage5 = new Stage();
        stage5.getIcons().add(new Image("view/edit.png"));
        stage5.setX(ViewLoader.X);
        stage5.setY(ViewLoader.Y);
        ViewLoader.showStage(m, "/view/Membership.fxml", "Adding New Membership", stage5);
    }
    
    @FXML private void handlereport(ActionEvent e) throws Exception{
        Stage stage9 = new Stage();
        stage9.getIcons().add(new Image("view/uts.jpeg"));
        stage9.setX(ViewLoader.X);
        stage9.setY(ViewLoader.Y);
        ViewLoader.showStage(model, "/view/mms.fxml", "MMS Report", stage9);
    }
    
    @FXML private void handleslip(ActionEvent e) throws Exception{
        Membership m = getmembership();
        m.setSuperMarket(model);
        Stage stage7 = new Stage();
        stage7.getIcons().add(new Image("view/edit.png"));
        stage7.setX(ViewLoader.X);
        stage7.setY(ViewLoader.Y);
        ViewLoader.showStage(m, "/view/slip.fxml", getmembership().getName() + " SLIP Report", stage7);
    }
    
}
