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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author dell pc
 */
public class AdminController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private Button login;

    @FXML
    private TextField admin;

    @FXML
    private PasswordField password;

    @FXML
    void loginAsAdmin(ActionEvent event) {
        String adm = admin.getText();
        String pas = password.getText();
            if(adm.equals("admin")&&pas.equals("admin")){
            
            try{
            Parent home_parent= FXMLLoader.load(getClass().getResource("Admindash.fxml"));
        Scene Home= new Scene(home_parent);

        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setScene(Home);
        window.show();
          }
catch(Exception e){
System.out.println(e);
}
            }else if(adm.equals("admin")){
                
            JOptionPane.showMessageDialog(null, "Incorrect Password");

            }
            else {
            JOptionPane.showMessageDialog(null, "Admin username Incorrect ");

            }
    }
    @FXML
    private Button back;

    @FXML
    void backhandler(ActionEvent event) {
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
