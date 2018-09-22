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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
    void handleButtonAction(ActionEvent event) {
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
       if(rs.first()){
       
       
       while(rs.next()){
       if(rs.getString("password").equals(password.getText())){
       JOptionPane.showMessageDialog(null,"Correct Password");
       }
       else{
       JOptionPane.showMessageDialog(null,"Incorrect Password");
               }
       }
       }
       else {
       JOptionPane.showMessageDialog(null,"Username not found");
       }
       }
       catch(SQLException e){
       e.printStackTrace();
       }
       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
