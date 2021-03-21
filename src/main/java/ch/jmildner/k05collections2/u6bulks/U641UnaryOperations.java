
package ch.jmildner.k05collections2.u6bulks;

import ch.jmildner.tools11.MyTools;
import java.util.function.UnaryOperator;

public final class U641UnaryOperations {

    public static void main(String[] args) {

        MyTools.h1("U641UnaryOperations");

        MyTools.h2("if the first char is uppercase, all chars are uppercase and v.v");
        {
            UnaryOperator<String> changer = (String s) -> {
                if (s == null) return "empty";
                if (s.length() == 0) return "empty";

                return Character.isUpperCase(s.charAt(0)) ? s.toUpperCase() : s.toLowerCase();
            };

            printResult1("Change1", null, changer);
            printResult1("Change2", "", changer);
            printResult1("Change2", "null", changer);
            printResult1("Change3", "MoNika", changer);
            printResult1("Change4", "Karin", changer);
            printResult1("Change5", "miCHaEL", changer);
        }

        MyTools.h2("makes a necessary trim");
        {
            UnaryOperator<String> trimmer = String::trim;

            printResult1("Trim1", "no trim necessary", trimmer);
            printResult1("Trim2", "  trim necessary ", trimmer);
            printResult1("Trim3", "   xxx yyy zzz   ", trimmer);
        }

        MyTools.h2("null strings becomes 'empty'");
        {
            UnaryOperator<String> mapper = s -> s == null ? "empty" : s;

            printResult1("SMapper1", "same string", mapper);
            printResult1("SMapper2", null, mapper);
        }

        MyTools.h2("null person becomes a person", 2);
        {
            UnaryOperator<Person6> pMapper = p -> p == null ? new Person6() : p;

            printResult2("PMapper1", new Person6(), pMapper);
            printResult2("PMapper2", null, pMapper);
        }
    }

    private static void printResult1(String text, String string, UnaryOperator<String> op) {
        System.out.printf("%-10s : %-30s ==> %s %n", text,
                string == null ? "null" : getValue(string),
                getValue(op.apply(string)));
    }

    private static void printResult2(String text, Person6 person, UnaryOperator<Person6> op) {
        System.out.printf("%-10s : %-40s ==> %s %n", text,
                person == null ? "null" : getValue(person.toString()),
                getValue(op.apply(person).toString()));
    }

    private static String getValue(String text) {
        return "[" + text + "]";
    }

}
