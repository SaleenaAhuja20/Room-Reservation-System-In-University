package oopsproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Database {
    private Connection db;

    public Database() {
        try {
            db = DriverManager.getConnection("jdbc:mysql://localhost:3306/roomreservationsysteminuniversity", "root", "abc123");
        } catch (Exception e) {
            System.out.println(e);
            
        }
    }

    public ResultSet fetchData(String query) {
        try {
            PreparedStatement statement = db.prepareStatement(query);
            return statement.executeQuery();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

    public PreparedStatement prepareStatement(String sql) throws Exception {
        return db.prepareStatement(sql);
    }
}
