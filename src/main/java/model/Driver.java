package model;

import java.sql.*;

public class Driver {

    public static void main(String[] args) {
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try{
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/seriesshelf", "student" , "student");

        }
    }
}
