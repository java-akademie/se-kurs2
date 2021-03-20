
package ch.jmildner.k10jdbc.a1;

import ch.jmildner.tools11.MyTools;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Aufgabe1c {

    private static final String URL = "jdbc:h2:tcp://localhost:9092/~/test;USER=sa;PASSWORD=sa";

    public static void main(String[] args) throws SQLException {
        MyTools.h1("Aufgabe1c - PreparedStatement");

        try (Connection c = DriverManager.getConnection(URL);
             Statement s = c.createStatement()) {

            s.execute("drop table person1c if exists");
            s.execute("create table person1c (id int primary key, name varchar(20), addr varchar(20))");

            String sql = "insert into person1c values(?,?,?)";
            try (PreparedStatement ps = c.prepareStatement(sql)) {
                for (int i = 1; i <= 20; i++) {
                    ps.setInt(1, i);
                    ps.setString(2, "name-" + (int) (1000 + Math.random() * 1000));
                    ps.setString(3, "addr-" + (int) (1000 + Math.random() * 1000));
                    ps.execute();
                }
            }

            s.execute("select * from person1c");

            try (ResultSet rs = s.getResultSet()) {
                while (rs.next()) {
                    System.out.println(""
                            + rs.getInt(1) + "/"
                            + rs.getString(2) + "/"
                            + rs.getString(3)
                    );
                }
            }
        }
    }

}
