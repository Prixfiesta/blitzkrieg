/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maybethistime;

import java.sql.*;

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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 *
 * @author dell pc
 */
public class FXMLDocumentController implements Initializable {
    Connection conn;
    @FXML
    private Label label;

    @FXML
    private Button login;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    void login(ActionEvent event) {
       ConnectionClass login = new ConnectionClass();
       conn = login.getConnection();
       try{ try{
       Class.forName("com.mysql.cj.jdbc.Driver");
       }
       catch(ClassNotFoundException e){
           System.out.println(e);
       }
       
       String query = "SELECT password FROM userdata where username='"+username.getText()+"';";
       PreparedStatement ps = conn.prepareStatement(query);
       ResultSet rs = ps.executeQuery();
       if(!rs.first()){
           JOptionPane.showMessageDialog(null, "username not found");
       }
       
       
       else{
       if(rs.getString("password").equals(password.getText())){
       JOptionPane.showMessageDialog(null,"Bahut ukhad liya");
       
       }
       
       else{
           
       JOptionPane.showMessageDialog(null,"Incorrect Password");
                    }
       }
       
//       else {
//       JOptionPane.showMessageDialog(null,"Username not found");
//       }
       }
       catch(SQLException e){
           JOptionPane.showMessageDialog(null, "username not found");
       e.printStackTrace();
       }
       
    }
     @FXML
    private Button signupdial;
     @FXML
    void opensignupform(ActionEvent event) {
try{
            Parent home_parent= FXMLLoader.load(getClass().getResource("Signup.fxml"));
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
