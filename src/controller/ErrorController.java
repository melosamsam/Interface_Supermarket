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

public class ErrorController extends Controller<Validator>  {
    @FXML private Button OkayBtn;
    @FXML private Label Lb1;
    @FXML private Label Lb2;
    @FXML private Label Lb3;
    @FXML private Label Lb4;
    @FXML private Label Lb5;
    
    
    @FXML private Validator getvalidator(){return model;}
    
    
    @FXML private void initialize(){
        LinkedList<String> listerrors = getvalidator().errors();
        Lb1.setText(listerrors.get(0));
        if(listerrors.size()>1){Lb2.setText(listerrors.get(1));}
        if(listerrors.size()>2){Lb3.setText(listerrors.get(2));}
        if(listerrors.size()>3){Lb4.setText(listerrors.get(3));}
        if(listerrors.size()>4){Lb5.setText(listerrors.get(4));}
    }
    
    
    @FXML private void handleokay(ActionEvent e) throws Exception{
        Stage stage = (Stage)OkayBtn.getScene().getWindow();
        stage.close();
    }

}
