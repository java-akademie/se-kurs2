
package ch.jmildner.k05collections2.u6bulks;
import ch.jmildner.tools11.MyTools;
import java.util.List;
import java.util.function.Consumer;

public final class U612InternalIteration {
    private static final List<String> listOfStrings = List.of("hans", "dampf", "in", "allen", "gassen");

    public static void main(String[] args) {
        MyTools.h1("U612InternalIteration");
        testAnonymousInnerClass();
        testLambda();
        testMethodReference();
        System.out.println();
    }
    private static void testAnonymousInnerClass() {
        MyTools.h2("testAnonymousInnerClass");
        MyTools.comment("action as variable");
        var action = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.print(s + " ");
            }
        };
        listOfStrings.forEach(action);

        MyTools.comment("action as constant",2);
        listOfStrings.forEach(new Consumer<>() {
            @Override
            public void accept(String s) {
                System.out.print(s + " ");
            }
        });
    }
    private static void testLambda() {
        MyTools.h2("testLambda", 3);
        MyTools.comment("action as variable");
        Consumer<String> action = s -> System.out.print(s + " ");
        listOfStrings.forEach(action);

        MyTools.comment("action as constant",2);
        listOfStrings.forEach(s -> System.out.print(s + " "));
    }
    private static void testMethodReference() {
        MyTools.h2("testMethodReference", 2);
        MyTools.comment("action as variable");
        Consumer<String> action = System.out::println;
        listOfStrings.forEach(action);

        MyTools.comment("action as constant",2);
        listOfStrings.forEach(System.out::println);
    }

}
