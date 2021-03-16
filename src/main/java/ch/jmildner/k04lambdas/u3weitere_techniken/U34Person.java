package ch.jmildner.k04lambdas.u3weitere_techniken;

public class U34Person {

    private final int id;
    private final String name;

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public U34Person(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString()
    {
        return id + "/" + name ;
    }

}
