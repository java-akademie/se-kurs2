
package ch.jmildner.k10jdbc.a2dao;

import ch.jmildner.tools11.MyTestDatenTools;
import ch.jmildner.tools11.MyTools;
import java.sql.SQLException;
import java.util.List;

public class Aufgabe2 {

    public static void main(String[] args) throws SQLException {
        new Aufgabe2().run("H2", true);
        new Aufgabe2().run("MYSQL-DOCKER-HOSTTECH", false);
        new Aufgabe2().run("MYSQL", false);
        new Aufgabe2().run("POSTGRES", false);
        new Aufgabe2().run("ORACLE", false);
    }


    public void run(String DB, boolean go) throws SQLException {
        if (!go)
            return;

        MyTools.h1("Start Aufgabe2 run() mit Database " + DB, 2);

        PersonDao dao = new PersonDaoImpl(DB);

        dao.drop();
        dao.create();

        for (int id = 1; id <= 20; id++) {
            Person p = new Person(id,
                    MyTestDatenTools.getLastName(),
                    MyTestDatenTools.getCity()
            );
            dao.insert(p);
        }

        showPersonen(dao.getAll());

        Person p5 = dao.getById(5);
        p5.setName("KARL MAY");
        dao.update(p5);

        System.out.printf("deleted by name(schuster): %d%n", dao.deleteByName("schuster"));

        System.out.printf("deleted by name(g*): %d%n", dao.deleteByName("g%"));

        System.out.printf("deleted by id(7): %d%n", dao.deleteById(7));

        showPersonen(dao.getAll());
        showPersonen(dao.getByName(""));


        MyTools.h2("End Aufgabe2 run() with  Database " + DB);
    }


    private static void showPersonen(List<Person> personen) {
        System.out.println();
        System.out.println("PERSONEN");
        System.out.println(Person.header());

        if (personen.isEmpty()) {
            System.out.println("   --- no people in table");
        } else {
            personen.forEach(System.out::println);
        }

        System.out.println();
    }
}
