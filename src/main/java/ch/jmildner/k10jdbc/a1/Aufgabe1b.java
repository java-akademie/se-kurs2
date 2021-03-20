
package ch.jmildner.k10jdbc.a1;

import ch.jmildner.tools11.MyTools;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Aufgabe1b {

    private static final String URL = "jdbc:h2:tcp://localhost:9092/~/test;USER=sa;PASSWORD=sa";

    public static void main(String[] args) throws SQLException {
        MyTools.h1("Aufgabe1b - TryWithResources");

        try (Connection c = DriverManager.getConnection(URL);
             Statement s = c.createStatement()) {
            s.execute("drop table PERSON if exists");
            s.execute("create table PERSON (id int, name varchar(64), addr varchar(64))");

            for (int i = 1; i <= 10; i++) {
                final String SQL =
                        String.format("insert into PERSON values(%1$d,'name-%1$d','ort-%1$d')", i);
                s.execute(SQL);
            }

            s.execute("select * from PERSON");

            try (ResultSet rs = s.getResultSet()) {
                while (rs.next()) {
                    System.out.println(""
                            + rs.getInt(1)
                            + "/"
                            + rs.getString(2));
                }
            }
        }
    }

}
