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
    public ResultSet fetchTeacherSchedule(int teacherId){
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM schedule WHERE Teacher_id = ?";
            PreparedStatement ps = db.prepareStatement(query);
            ps.setInt(1, teacherId);
            resultSet = ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }
     public void close() {
        try {
            if (db != null) {
                db.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }

    

