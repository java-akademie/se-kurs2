
package ch.jmildner.k10jdbc.a1;

import ch.jmildner.tools11.MyPoolingDataSource;
import ch.jmildner.tools11.MyTools;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

public class Aufgabe1d {
    private final String DATABASE;
    private final DataSource DS;

    public static void main(String[] args) throws SQLException {
        var ref = new Aufgabe1d("H2");
        ref.run();
    }

    public Aufgabe1d(final String DB) {
        this.DATABASE = DB;
        this.DS = new MyPoolingDataSource(DATABASE).getDataSource();
    }

    private void run() throws SQLException {
        MyTools.h1("Aufgabe1d run() with DB: " + DATABASE);

        try (Connection c = DS.getConnection()) {
            drop(c);
            create(c);
            insert(c);
            select(c);
            selectCount(c);
            update(c);
            select(c);
            delete(c);
            select(c);
        }

        MyTools.h2("Stop Aufgabe1d run() with DB: " + DATABASE);
    }

    private void drop(Connection c) throws SQLException {
        try (Statement s = c.createStatement()) {
            s.execute("drop table person1d if exists");
        }
    }

    private void create(Connection c) throws SQLException {
        try (Statement s = c.createStatement()) {
            s.execute("create table person1d "
                    + "(id int primary key, name varchar(20), addr varchar(20))");
        }
    }

    private void insert(Connection c) throws SQLException {
        try (PreparedStatement ps =
                     c.prepareStatement("insert into person1d values(?,?,?)")) {
            for (int i = 1; i <= 10; i++) {
                ps.setInt(1, i);
                ps.setString(2,
                        "name-" + (int) (1000 + Math.random() * 1000));
                ps.setString(3,
                        "addr-" + (int) (1000 + Math.random() * 1000));
                ps.execute();
            }
        }
    }

    private void delete(Connection c) throws SQLException {
        try (Statement s = c.createStatement()) {
            System.out.printf("Number deleted: %d %n",
                    s.executeUpdate("delete from person1d where addr like 'addr-1%'"));
        }
    }

    private void update(Connection c) throws SQLException {
        try (Statement s = c.createStatement()) {
            System.out.printf("Number updated: %d %n",
                    s.executeUpdate("update person1d set name='max' where id = 5"));
        }
    }

    private void selectCount(Connection c) throws SQLException {
        String sql = "select count(*) from person1d";
        try (Statement s = c.createStatement()) {
            s.execute(sql);
            try (ResultSet rs = s.getResultSet()) {
                while (rs.next()) {
                    System.out.printf("count(*) %5d %n",
                            rs.getInt(1));
                }
            }

        }
    }

    private void select(Connection c) throws SQLException {
        String sql = "select id, name, addr from person1d  order by name";

        try (Statement s = c.createStatement()) {
            s.execute(sql);
            try (ResultSet rs = s.getResultSet()) {
                while (rs.next()) {
                    System.out.printf(" %5d  %-20s  %-20s %n",
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3)
                    );
                }
            }
            System.out.println();
        }
    }

}

