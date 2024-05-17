/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopsproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Siloo
 */
class Database {
     Connection db;

  public  Database(){ 
        try{
     db =   DriverManager.getConnection( "jdbc:mysql://localhost:3306/roomreservationsysteminuniversity", "root", "abc123"); 
        }
        catch(Exception e){
            
           System.out.println(e);
            
        }
    }
    
    public ResultSet fatchData(String query){
         try {
                PreparedStatement statement = db.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery();
                return resultSet;



            } catch (Exception ex) {
                System.out.println(ex);
            }
            return null;
        }
}
