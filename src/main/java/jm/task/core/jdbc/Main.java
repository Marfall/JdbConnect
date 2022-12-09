package jm.task.core.jdbc;

import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // Get Connection
        Connection connection = Util.getMySQLConnection();

        // Create statement
        Statement statement = connection.createStatement();

        String sql = "Select * from user";

        // Execute SQL statement returns a ResultSet object.
        ResultSet rs = statement.executeQuery(sql);

        // Fetch on the ResultSet
        // Move the cursor to the next record.
        while (rs.next()) {
            int userId = rs.getInt(1);
            String userName = rs.getString(2);
            System.out.println("--------------------");
            System.out.println("userId:" + userId);
            System.out.println("userName:" + userName);
        }

        // Close connection.
        connection.close();
    }
}
