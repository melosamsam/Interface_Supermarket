package controller;

import model.*;
import javafx.fxml.*;
import javafx.stage.*;
import javafx.event.*;
import javafx.scene.control.*;
import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.scene.image.Image;



public class SessionController extends Controller<Session>
{
    /*@FXML private ListView<SuperMarket> supermarketLv;
    public final SuperMarkets getSupermarkets(){ return model;}
    @FXML private void initialize() {
    }*/
    
    @FXML private void handleOpen(ActionEvent event) throws Exception {
        Stage stage2 = new Stage();
        stage2.getIcons().add(new Image("view/book.png"));
        stage2.setX(ViewLoader.X);
        stage2.setY(ViewLoader.Y);
        ViewLoader.showStage(new Session(), "/view/MMSlogin.fxml", "Sign In", stage2);
    }
    
    @FXML private void handleClose(ActionEvent e) throws Exception{
        javafx.application.Platform.exit();
    }
}
