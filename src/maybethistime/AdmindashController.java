/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maybethistime;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dell pc
 */
public class AdmindashController implements Initializable {
@FXML
    private Button signout;

    @FXML
    private Label WelcomeLabel;

    @FXML
    private Button view;

    @FXML
    private Button add;

    @FXML
    void addHandler(ActionEvent event) {
            try{
                     Parent home_parent= FXMLLoader.load(getClass().getResource("AddProduct.fxml"));
                 Scene Home= new Scene(home_parent);

                 Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
                 window.setScene(Home);
                 window.show();
                   }
         catch(Exception e){
         System.out.println(e);
         }
    }

    @FXML
    void signoutHandler(ActionEvent event) {
 try{
                     Parent home_parent= FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                 Scene Home= new Scene(home_parent);

                 Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
                 window.setScene(Home);
                 window.show();
                   }
         catch(Exception e){
         System.out.println(e);
         }
    }

    @FXML
    void viewHandler(ActionEvent event) {

    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
