package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.image.Image;
import model.*;

public class MMSLoginController extends Controller<Session>  {
    @FXML private TextField emailTf;
    @FXML private PasswordField passwordTf;
    @FXML private Label wrongloginTxt;
    @FXML private Button cancelBtn;
    private Session getSession(){return model;}
    
    /*public final SuperMarkets getSupermarkets(){return model;}*/
    private final String getEmail(){ return emailTf.getText();}
    private final String getPassword(){ return passwordTf.getText();}
    private final void setErrorTxt(String strg){ wrongloginTxt.setText(strg);}
    private final void setEmail(String value){emailTf.setText(value);}
    private final void setPassword(String value){passwordTf.setText(value);}
    
    
    @FXML private void handleok(ActionEvent event) throws Exception{
        
        /*Stage stage3 = new Stage();
        stage3.getIcons().add(new Image("view/book.png"));
        stage3.setX(ViewLoader.X);
        stage3.setY(ViewLoader.Y);
        ViewLoader.showStage(new Session(), "/view/SuperMarket.fxml", "Session Admin: ", stage3);
        
        
        boolean found=false;
        for(int i=0;i<getSession().getSuperMarket().size();i++)
        {
            if(supermarkets.getSupermarketslist().get(i).getEmail().equals(email) && supermarkets.getSupermarketslist().get(i).getPassword().equals(password))
            {
                SuperMarket login = getSupermarkets().getSupermarketslist().get(i);
                found = true;
            }
        }*/
        String email = getEmail();
        String password = getPassword();
        if(getSession().getSuperMarket(email,password)!=null)
        {
            setErrorTxt("");
            Stage stage3 = new Stage();
            stage3.getIcons().add(new Image("view/SuperMarket.png"));
            stage3.setX(ViewLoader.X);
            stage3.setY(ViewLoader.Y);
            ViewLoader.showStage(getSession().getSuperMarket(email,password), "/view/SuperMarket.fxml", "Session Admin: "+getSession().getSuperMarket(email,password).getName(), stage3);
        }
        else
        {
            setErrorTxt("Incorrect login details");
            setEmail("");
            setPassword("");
        }
    }
    
    @FXML private void handlecancel(ActionEvent e) throws Exception{
        Stage stage = (Stage)cancelBtn.getScene().getWindow();
        stage.close();
    }
    
}

