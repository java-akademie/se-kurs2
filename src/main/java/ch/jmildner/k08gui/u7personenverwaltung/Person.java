
package ch.jmildner.k08gui.u7personenverwaltung;

import ch.jmildner.tools11.MyTools;
import ch.jmildner.tools11.MyTestDatenTools;
import java.util.Objects;


public class Person {
    private int id;
    private String name;
    private String addr;

    public Person() {
        id = MyTools.getRandom(1000, 9999);
        name = MyTestDatenTools.getName();
        addr = MyTestDatenTools.getAddress();
    }

    public Person(int id, String name, String addr) {
        this.id = id;
        this.name = name;
        this.addr = addr;
    }

    public Person(String buffer) {
        String[] arr = buffer.split("~");
        id = Integer.parseInt(arr[0]);
        name = arr[1];
        addr = arr[2];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return id + "~" + name + "~" + addr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
