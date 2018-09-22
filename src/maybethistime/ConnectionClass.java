/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maybethistime;
import java.sql.*;
import java.util.*;

/**
 *
 * @author dell pc
 */
 class ConnectionClass {
     public Connection connection;
    public Connection getConnection(){
        String url = "jdbc:mysql://localhost:3306/hopethisworks?useSSL=false";
        String user = "root";
        String  pass =  "root";
        
        try{
             connection = DriverManager.getConnection(url,user,pass);
        }
        catch(Exception e){
            System.out.println(e);
        }
        return connection;
    }
}
