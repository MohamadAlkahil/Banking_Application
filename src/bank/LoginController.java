/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kahil
 */
public class LoginController implements Initializable {
    @FXML
    private TextField UserName, Password;
    private Button Login;
    
    
    @FXML
    public void LoginPushed(ActionEvent event)throws IOException{
        
        String User = UserName.getText();
        String Pass = Password.getText();
        SHA256 HashObj = new SHA256();
        String HashedPass = "";
        try {
            HashedPass = HashObj.toHexString(HashObj.getSHA(Pass));
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Customer cust = new Customer(User, HashedPass, "Customer");
            Manager man = new Manager(User,Pass,"Manager");
            if(man.LoginCheck()){
                FXMLLoader loader= new FXMLLoader(getClass().getResource("Manager_Window.fxml"));
                Parent root=loader.load();
                Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene  = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            else if(cust.LoginCheck()){
                FXMLLoader loader= new FXMLLoader(getClass().getResource("Customer_Window.fxml"));
                Parent root=loader.load();
                Customer_WindowController Controller= loader.getController();
                try {
                   Controller.DisplayName(cust);
                } catch (Exception ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
                Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene  = new Scene(root);
                stage.setScene(scene);
                stage.show();
            
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText("Invalid Username or Password");
                alert.showAndWait().get();   
            }
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("The Start!");
    }    
    
}
