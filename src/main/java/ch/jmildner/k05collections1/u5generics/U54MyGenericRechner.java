package ch.jmildner.k05collections1.u5generics;

public class U54MyGenericRechner<T> {

    private  T a;
    private  T b;

    public void setOperands(T a,T b) {
        this.a=a;
        this.b=b;
    }

    public T rechne(U53MyIGenericRechner<T> ir) {
        return ir.rechne(a, b);
    }
}
