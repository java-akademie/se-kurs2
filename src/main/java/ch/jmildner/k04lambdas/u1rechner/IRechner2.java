
package ch.jmildner.k04lambdas.u1rechner;

@FunctionalInterface
public interface IRechner2<T> {
    T rechne(T a, T b, char op);
}
