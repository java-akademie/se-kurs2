
package ch.jmildner.k05collections2.u6bulks;

import ch.jmildner.tools11.MyDateTimeTools;
import ch.jmildner.tools11.MyTestDatenTools;
import ch.jmildner.tools11.MyTools;
import java.util.Objects;

public class Person6 implements Comparable<Person6> {

    private final Integer id;
    private final String name;
    private final String addr;
    private final Integer age;
    private final Integer gender;

    public Person6() {
        this.gender = MyTools.getRandom(1, 2);
        this.id = MyTools.getRandom(1001, 1020); // w/distinct
        this.name = MyTestDatenTools.getFirstName(gender);
        this.addr = MyTestDatenTools.getCity();
        this.age = MyDateTimeTools.getRandomAge(21);
    }

    public Boolean isAdult() {
        return age >= 18;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddr() {
        return addr;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return String.format("%s / %s / %s / %s / %s", id, name, addr, age, gender);
    }

    @Override
    public int compareTo(Person6 o) {
        String s1=String.format("%10s/%20s/%2d",this.id,this.name,this.age);
        String s2=String.format("%10s/%20s/%2d",o.id,o.name,o.age);
        return s1.compareTo(s2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person6 person6 = (Person6) o;
        return Objects.equals(id, person6.id);
    }

    public void show() {
        System.out.printf("Person[id=%d, name=%s, addr=%s, alter=%d, gender=%s] %n",
                id, name, addr, age, gender == 1 ? "W" : "M");
    }

}
