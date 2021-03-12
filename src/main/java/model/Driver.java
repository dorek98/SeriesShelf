package model;

import java.sql.*;

public class Driver {

    public static void main(String[] args) throws SQLException {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        Actor actor = new Actor("Adam", "Sandler", 45);
        Actor actor2 = new Actor("Hugh", "Jackman", 52);

        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/series_shelf", "student", "student");
            myStmt = myConn.createStatement();
            int addedRow = actor2.addToDB(myStmt);
            /*
            myStmt = myConn.prepareStatement("INSERT INTO actor (first_name, last_name, age) VALUES (?,?,?)");
            myStmt.setString(1,actor.getFirstname());
            myStmt.setString(2, actor.getLastname());
            myStmt.setInt(3, actor.getAge());
            int addedRow = myStmt.executeUpdate();
            // myStmt.setString(1, "actor");
            //int addedRow = myStmt.executeUpdate("INSERT INTO actor (first_name, last_name, age) VALUES ('?','?',?)");
            //int addedRow = myStmt.executeUpdate("delete from actor " + "where last_name='Actor'");
            */

            myRs = myStmt.executeQuery("select * from actor");
            while (myRs.next()) {
                System.out.println(myRs.getString("first_name") + ", " + myRs.getString("last_name") + ", " + myRs.getInt("age"));
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();
            }

        }
    }
}
