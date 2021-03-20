package ch.jmildner.k05collections1.u5generics;

import java.util.ArrayList;
import java.util.List;

public class U51MyGenericClass<T> {

    private final List<T> list = new ArrayList<>();

    public boolean insert(T o) {
        return list.add(o);
    }

    public T remove(int i) {
        return list.remove(i);
    }

    public boolean remove(T o) {
        return list.remove(o);
    }

    public List<T> get() {
        return list;
    }

    public T get(int i) {
        return list.get(i);
    }
}
