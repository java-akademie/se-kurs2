
package ch.jmildner.k03auffrischung.u3;

import java.util.ArrayList;
import java.util.List;

public class U31GenericList<T>
{
    List<T> list = new ArrayList<>();

    void add(T o)
    {
        list.add(o);
    }

    List<T> get()
    {
        return list;
    }
}
