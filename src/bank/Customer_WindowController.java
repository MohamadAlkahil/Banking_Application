/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.io.IOException;
import static java.lang.Double.parseDouble;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kahil
 */
public class Customer_WindowController implements Initializable {
    @FXML
    private Label UserLabel, Balance, Level;
    @FXML
    private TextField Amount;
    @FXML
    private AnchorPane scenePane;
    @FXML
    Stage stage;
    
    private Customer C;
    
    @FXML
    public void DisplayName(Customer C) throws Exception{
        this.C=C;
        UserLabel.setText("Hello, "+this.C.getusername());
        DisplayBalance();
        DisplayLevel();
    }
    

    @FXML
    public void DisplayBalance() throws Exception{
        Balance.setText("Balance: $"+this.C.getbalance());
    }
    
    @FXML
    public void DisplayLevel() throws Exception{
        Level.setText("Account Level: "+this.C.getlevel()+"\nMonthly Fee: $"+this.C.getfee());
    }
    
    @FXML
    public void WithdarwPushed(ActionEvent event) throws Exception{
        String Amnt = Amount.getText();
        double doubleAmnt=parseDouble(Amnt);
        
        if(doubleAmnt > this.C.getbalance()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Withdraw amount is greater than available funds");
            alert.showAndWait().get();           
        }
        else{
            this.C.UpdateBalance( -doubleAmnt);
            DisplayBalance();
            DisplayLevel();
        }
        
    }
    
    @FXML
    public void DepositPushed(ActionEvent event) throws Exception{
        String Amnt = Amount.getText();
        double doubleAmnt=parseDouble(Amnt);
       this.C.UpdateBalance(doubleAmnt);
       DisplayBalance();
       DisplayLevel();
        
    }
    
    @FXML
    public void LogoutPushed(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to logout!");
		
        if(alert.showAndWait().get() == ButtonType.OK){
                stage = (Stage) scenePane.getScene().getWindow();
                System.out.println("You successfully logged out!");
                stage.close();
        }
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }    
    
}
