package ch.jmildner.k10jdbc.a1;

import ch.jmildner.tools11.MyDbTools;
import ch.jmildner.tools11.MyPoolingDataSource;
import ch.jmildner.tools11.MyTools;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

public class Aufgabe1e {
    private final String DATABASE;
    private final DataSource DS;

    public static void main(String[] args) throws SQLException {
        new Aufgabe1e("H2").run(true);
        new Aufgabe1e("MYSQL").run(false);
        new Aufgabe1e("POSTGRES").run(false);
        new Aufgabe1e("ORACLE").run(false);
    }

    public Aufgabe1e(final String DB) {
        this.DATABASE = DB;
        this.DS = new MyPoolingDataSource(DATABASE).getDataSource();
    }

    private void run(boolean go) throws SQLException {
        if (!go)
            return;

        MyTools.h1("Aufgabe1e run() with DB: " + DATABASE);

        try (Connection c = DS.getConnection()) {
            drop(c);
            create(c);
            insert(c);
            select(c);
            selectCount(c);
            update(c);
            delete(c);
            select(c);
        }

        MyTools.h2("Stop Aufgabe1e run() with DB: " + DATABASE);
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
        MyDbTools.select(c, "select count(*) from person1d");
    }

    private void select(Connection c) throws SQLException {
        MyDbTools.select(c, "select id, name, addr from person1d  order by name");
    }

    private void drop(Connection c) {
        try (Statement s = c.createStatement()) {
            s.execute("drop table person1d if exists");
        } catch (Exception e) {
            e.printStackTrace();
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

}
