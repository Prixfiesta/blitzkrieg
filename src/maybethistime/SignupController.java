/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maybethistime;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author dell pc
 */
public class SignupController implements Initializable {
Connection conn;
    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField username;

    @FXML
    private PasswordField password;
     @FXML
    private Button Signup;

    @FXML
    private PasswordField repassword;

    @FXML
    void signuphandler(ActionEvent event) {
        ConnectionClass signup = new ConnectionClass();
        conn = signup.getConnection();
        try{
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                }
        catch(ClassNotFoundException e){
             System.out.println(e);
        }
        String u = username.getText();
        String p = password.getText();
        String rp = repassword.getText();
            if(u.equals("")){
            JOptionPane.showMessageDialog(null,"I am gonna need a name!");
            }
            else{
            if(p.equals("")){
            JOptionPane.showMessageDialog(null,"Enter a much much stronger password!");
            }
            else{
                if(p.equals(rp)){
       //implement unique username
       
                    String query = "INSERT INTO `userdata`(`username`,`password`) VALUES ('"+u+"','"+p+"');";
                    System.out.println(query);    
                    PreparedStatement ps = conn.prepareStatement(query);
                    ps.executeUpdate();
                 }
                else{
                    JOptionPane.showMessageDialog(null,"Passwords do not match!");
                }
            }
        }
    }
    catch(SQLException e){
        System.out.println(e);    
                 
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
