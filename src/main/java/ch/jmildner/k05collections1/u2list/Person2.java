
package ch.jmildner.k05collections1.u2list;
import ch.jmildner.tools11.MyTools;
import java.util.Objects;

public class Person2 implements Comparable<Person2> {
    private String id;
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public Person2() {
        id = MyTools.getRandom(10,99)+"";
        name = "name-" + id;
    }

    public Person2(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(Person2 that) {
        return this.id.compareTo(that.id);
    }

    @Override
    public String toString() {
        return id + "/" + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person2 person2 = (Person2) o;
        return Objects.equals(id, person2.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

