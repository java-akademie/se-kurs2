
package ch.jmildner.k10jdbc.a3one2many;

import ch.jmildner.tools11.MyDbTools;
import ch.jmildner.tools11.MyPoolingDataSource;
import ch.jmildner.tools11.MyTools;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

public class A30OneToMany {

    private final String DATABASE;
    private final DataSource DS;

    public static void main(String[] args) throws SQLException {
        new A30OneToMany("H2").run(true);
        new A30OneToMany("MYSQL-DOCKER-HOSTTECH").run(false);
        new A30OneToMany("MYSQL").run(false);
        new A30OneToMany("POSTGRES").run(false);
        new A30OneToMany("ORACLE").run(false);
    }

    public A30OneToMany(final String DB) {
        this.DATABASE = DB;
        this.DS = new MyPoolingDataSource(DATABASE).getDataSource();
    }

    private void run(boolean go) throws SQLException {
        if (!go)
            return;

        MyTools.h2("Start A30OneToMany run() mit DB: " + DATABASE, 2);

        try (Connection c = DS.getConnection()) {
            drop(c, "mitarbeiter");
            drop(c, "abteilung");
            create(c, "abteilung");
            create(c, "mitarbeiter");
            insert(c);
            select(c);
        }

        MyTools.h2("Stop A30OneToMany run() with DB: " + DATABASE);
    }

    private void drop(Connection c, String tableName) {
        try (Statement s = c.createStatement()) {
            s.execute("drop table " + tableName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void create(Connection c, String tableName) throws SQLException {
        try (Statement s = c.createStatement()) {
            switch (tableName) {
                case "abteilung":
                    s.execute("create table abteilung " +
                            "(id int not null primary key,  abt_name varchar(20))");
                    break;
                case "mitarbeiter":
                    s.execute("create table mitarbeiter " +
                            "(id int not null primary key, ma_name varchar(20), " +
                            "id_Abteilung int not null, " +
                            "foreign key (id_Abteilung) references abteilung(id))");
                    break;
            }
        }
    }

    private void insert(Connection c) throws SQLException {
        try (Statement s = c.createStatement()) {
            s.execute("insert into abteilung values(101, 'buchhaltung')");
            s.execute("insert into abteilung values(102, 'einkauf')");
            s.execute("insert into mitarbeiter values(11, 'huber', 101)");
            s.execute("insert into mitarbeiter values(12, 'meier', 102)");
            s.execute("insert into mitarbeiter values(13, 'gruber', 102)");
        }
    }

    private void select(Connection c) throws SQLException {
        System.out.println("\nABTEILUNG");
        MyDbTools.select(c, "select id ID, abt_name ABTEILUNG_NAME from abteilung");

        System.out.println("\nMITARBEITER");
        MyDbTools.select(c, "select id, ma_name, id_Abteilung from mitarbeiter");

        System.out.println("\nMITARBEITER IN ABTEILUNG");
        MyDbTools.select(c, "select m.id, m.ma_name, a.abt_name  " + "from mitarbeiter m join abteilung a "
                + "on a.id = m.id_Abteilung");
    }

}
