/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maybethistime;

import java.io.File;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author dell pc
 */
public class AddProductController implements Initializable {
 @FXML
    private Button addbut;

    @FXML
    private TextField model;

    @FXML
    private TextField brand;

    @FXML
    private TextField category;

    @FXML
    private TextField cost;

    @FXML
    private TextField stock;
    @FXML
    private Button back;
    @FXML
    void backhandler(ActionEvent event) {
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
    }
    @FXML
    private Button browse;
    @FXML
    private TextField image;

    @FXML
    void addproduct(ActionEvent event) {
                ConnectionClass product = new ConnectionClass();
        conn = product.getConnection();
        try{
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                }
        catch(ClassNotFoundException e){
             System.out.println(e);
        }
            try{
                
        String m = model.getText();
        String b = brand.getText();
        String cat = category.getText();
        String img = image.getText();
        int  cos = parseInt(cost.getText());
        int sto = parseInt(stock.getText());
        
        
        
        
        
        
       if(m.equals("")||b.equals("")||cat.equals("")){
            JOptionPane.showMessageDialog(null,"Please Provide Proper Brand,Category and Image Source!");
            }
       else {    
           String check = "SELECT * FROM product where brand='"+b+"' and model='"+m+"';";
       PreparedStatement p = conn.prepareStatement(check);
       ResultSet rs = p.executeQuery();
       if(rs.first()){
//           JOptionPane.showMessageDialog(null, "Product already Exists with stock.\nIncreasing Stock");
           int sck = rs.getInt(4);
           
           
           JOptionPane.showMessageDialog(null, "Product already Exists with stock="+sto+".\nIncreasing Stock");
           sck  = sck+sto;
           String addstock = "UPDATE product SET stock = '"+sck+"' where brand='"+b+"' and model='"+m+"';";
            System.out.println(addstock);    
                    PreparedStatement ps = conn.prepareStatement(addstock);
                    ps.executeUpdate();
       }
       
            else{
                    
           
                  String query = "INSERT INTO `product`(`category`,`brand`,`model`,`stock`,`image`,`price`) VALUES ('"+cat+"','"+b+"','"+m+"','"+sto+"','"+img+"','"+cos+"');";
                    System.out.println(query);    
                    PreparedStatement ps = conn.prepareStatement(query);
                    ps.executeUpdate();
                 }
       }   
            }
        
            

        catch(NumberFormatException e){
              JOptionPane.showMessageDialog(null,"Fill in the required Integer!");
        System.out.println(e);
        }
            
           
        }
    catch(SQLException e){
        System.out.println(e);    
                 
    }
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
    Connection conn;
    @FXML
    void browsehandler(ActionEvent event) {
         FileChooser fileChooser = new FileChooser();
 fileChooser.setTitle("Open Resource File");
 FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Select an image", "*.png");
// 
//
//
 File selectedFile = fileChooser.showOpenDialog(null);
// if (selectedFile != null) {
//    mainStage.display(selectedFile);
// }
String str = selectedFile.getName();
image.setText(str);
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
