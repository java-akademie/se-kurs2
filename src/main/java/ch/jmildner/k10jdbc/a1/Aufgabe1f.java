package ch.jmildner.k10jdbc.a1;

import ch.jmildner.tools11.MyDbTools;
import ch.jmildner.tools11.MyPoolingDataSource;
import ch.jmildner.tools11.MyTools;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

public class Aufgabe1f {

    private final double MAX_SECONDS = 3;

    public static void main(String[] args) throws SQLException {
        new Aufgabe1f().run();
    }

    private void run() throws SQLException {
        timeTest("H2", true);
        timeTest("MYSQL", false);
        timeTest("POSTGRES", false);
        timeTest("ORACLE", false);
    }

    private void timeTest(String DATABASE, boolean go) throws SQLException {
        if (!go)
            return;

        MyTools.h1("timing for " + DATABASE);

        timeTestWithoutPooling(DATABASE);
        timeTestWithPooling(DATABASE);
    }

    private void timeTestWithoutPooling(String DATABASE) throws SQLException {
        long counter = 0;
        long t = (long) (System.currentTimeMillis() + MAX_SECONDS * 1000);
        int sum = 0;
        while (System.currentTimeMillis() < t) {
            try (Connection c = DriverManager.getConnection(MyDbTools.getUrl(DATABASE))) {
                c.getMetaData().getDatabaseProductName();
                sum += getCount(c);
                counter++;
            }
        }
        System.out.printf("getConnections without Pool in %4.2f seconds: %,10d (sum=%d) %n",
                MAX_SECONDS, counter, sum);
    }

    private void timeTestWithPooling(String DATABASE) throws SQLException {
        final DataSource DS = new MyPoolingDataSource(DATABASE).getDataSource();

        long counter = 0;
        long t = (long) (System.currentTimeMillis() + MAX_SECONDS * 1000);
        int sum = 0;
        while (System.currentTimeMillis() < t) {
            try (Connection c = DS.getConnection()) {
                c.getMetaData().getDatabaseProductName();
                sum += getCount(c);
                counter++;
            }
        }
        System.out.printf("getConnections with    Pool in %4.2f seconds: %,10d (sum=%d) %n",
                MAX_SECONDS, counter, sum);
    }

    private int getCount(Connection c) throws SQLException {
        int sum = 0;
        String sql = "select count(*) from person1a";
        try (Statement s = c.createStatement()) {
            s.execute(sql);
            try (ResultSet rs = s.getResultSet()) {
                while (rs.next()) {
                    sum += rs.getInt(1);
                }
            }
            return sum;
        }
    }
}
