package ch.jmildner.k05collections2.u7streams;

import ch.jmildner.tools11.MyTools;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class U732DoubleColonOperator {

    private final String[] sArray = {"Hans", "Dampf", "in", "allen", "Gassen"};

    public static void main(String[] args) {
        new U732DoubleColonOperator().doIt();
    }

    private void doIt() {
        MyTools.h2("Consumer anonymous inner class");
        {
            var action = new Consumer<String>() {
                @Override
                public void accept(String t) {
                    System.out.println(t);
                }
            };
            Stream<String> stream = Stream.of(sArray);
            stream.forEach(action);
        }

        MyTools.h2("Consumer action Lambda", 1);
        {
            Stream<String> stream = Stream.of(sArray);
            Consumer<String> action = s -> System.out.println(s);
            stream.forEach(action);
        }

        MyTools.h2("Consumer action Method Reference", 1);
        {
            Stream<String> stream = Stream.of(sArray);
            Consumer<String> action = System.out::println;
            stream.forEach(action);
        }


        MyTools.h2("direct anonymous inner class", 3);
        {
            Stream<String> stream = Stream.of(sArray);
            stream.forEach(
                    new Consumer<>() {
                        @Override
                        public void accept(String t) {
                            System.out.println(t);
                        }
                    }

            );
        }

        MyTools.h2("direct Lambda", 1);
        {
            Stream<String> stream = Stream.of(sArray);
            stream.forEach(s -> System.out.println(s));
        }

        MyTools.h2("direct Method Reference", 1);
        {
            Stream<String> stream = Stream.of(sArray);
            stream.forEach(System.out::println);
        }

        MyTools.h2("staticWrite(String)", 3);
        {
            Stream<String> stream2 = Stream.of(sArray);
            stream2.forEach(U732DoubleColonOperator::staticWrite);
        }

        MyTools.h2("write(String)", 1);
        {
            Stream<String> stream2 = Stream.of(sArray);
            stream2.forEach(this::write);
        }
    }

    private void write(String s) {
        System.out.println(s);
    }

    private static void staticWrite(String s) {
        System.out.println(s);
    }
}
