
package ch.jmildner.k10jdbc.a1;

import ch.jmildner.tools11.MyTools;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Aufgabe1a {

    private static final String URL_H2 = "jdbc:h2:tcp://localhost:9092/~/test;USER=sa;PASSWORD=sa";

    public static void main(String[] args) throws SQLException {
        MyTools.h1("Aufgabe1a - FiveStepsPerson");

        // Step 1: Connection to Database
        Connection c = DriverManager.getConnection(URL_H2);

        // Step 2: Create the Statement
        Statement s = c.createStatement();

        // Step 3: Execute a DB Command (no result provided)
        try {
            s.execute("drop table person1a");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Step 3: Execute another DB Command (no result provided)
        s.execute("create table person1a " +
                "(id int primary key, name varchar(20), addr varchar(20))");

        // Step 3: Execute another DB Command (no result provided)
        for (int i = 1; i <= 20; i++) {
            s.execute("insert into person1a values("
                    + i + ",'hugo-" + i + "','addr-" + i + "')");
        }

        // Step 3: Execute another DB Command (result provided)

        s.execute("select id,name,addr from person1a order by id");


        // Step 4: Use the Result that the DB Command provided
        ResultSet rs = s.getResultSet();
        while (rs.next()) {
            System.out.printf("%5d      %-20s %-20s %n",
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3));
        }
        rs.close();

        // Step 5: Close the Connection to the Database
        s.close();
        c.close();
    }
}
