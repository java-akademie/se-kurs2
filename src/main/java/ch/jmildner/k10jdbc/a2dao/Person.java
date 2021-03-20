
package ch.jmildner.k10jdbc.a2dao;

public class Person {
    private Integer id;
    private String name;
    private String addr;

    public Person(Integer id, String name, String addr) {
        this.id = id;
        this.name = name;
        this.addr = addr;
    }

    public static String header() {
        return String.format("%5s  %-20s  %-20s", "ID", "NAME", "ADDRESS");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    @Override
    public String toString() {
        return String.format("%5d  %-20s  %-20s ",
                getId(),
                getName(),
                getAddr());
    }
}
