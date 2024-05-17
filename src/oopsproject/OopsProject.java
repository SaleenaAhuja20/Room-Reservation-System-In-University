/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package oopsproject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author Siloo
 */
public class OopsProject {
        public static Connection conn(){
            try {
               String url = "jdbc:mysql://localhost:3306/roomreservationsysteminuniversity";
                String user = "root";
                String password = "abc123";
                 Class.forName("com.mysql.cj.jdbc.Driver");
                
                Connection conn = DriverManager.getConnection(url, user, password);
                return conn;
                
                
            } catch (SQLException|ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, e);
            }
            return null;
            
        }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connection conn = OopsProject.conn();
        PreparedStatement pst;
        ResultSet rs;
        try{
        String sqlquery = "SELECT * from teacher";
        pst = conn.prepareStatement(sqlquery);
        rs = pst.executeQuery();
        if(rs.next()){
            System.out.println(rs);
        }
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
