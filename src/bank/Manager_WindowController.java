/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kahil
 */
public class Manager_WindowController implements Initializable {
    @FXML
    private AnchorPane scenePane;
    @FXML
    Stage stage;
    @FXML
    private TextField UserNameAdd, Password, UserNameDelete;
    
    @FXML
    public void AddPushed(ActionEvent event) throws Exception{
        String User = UserNameAdd.getText();
        String Pass = Password.getText();
        Manager M = new Manager("User","Pass","Manager");
        M.AddCustomer(User,Pass);
        
    }
    
    @FXML
    public void DeletePushed(ActionEvent event) throws Exception{
        String User = UserNameDelete.getText();
        Manager M = new Manager("User","Pass","Manager");
        M.RemoveCustomer(User);
        
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
