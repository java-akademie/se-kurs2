
package ch.jmildner.k05collections2.u6bulks;

import ch.jmildner.tools11.MyTools;
import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public final class U651ChangeList {

    public static void main(String[] args) {
        MyTools.h1("U651ChangeList - replaceAll");

        List<String> names = createNamesList();
        showNames(names, "after createNames");

        UnaryOperator<String> nullToEmpty = s -> s == null ? "" : s;
         names.replaceAll(nullToEmpty);
        showNames(names, "after nullToEmpty");

        names.removeIf(String::isEmpty);
        showNames(names, "after removeIf(isEmpty)");

        names.replaceAll(String::trim);
        showNames(names, "after trim");
    }

    private static void showNames(List<String> names, String comment) {
        MyTools.h2("Names: " + comment, 2);
        names.forEach(s->System.out.println(s));
        System.out.println("-------------");
        names.forEach(s->U651ChangeList.printValue(s));
        System.out.println("-------------");
        names.forEach(U651ChangeList::printValue);
    }

    private static List<String> createNamesList() {
        MyTools.h2("createNamesList");

        List<String> names = new ArrayList<>();

        names.add("");
        names.add(null);
        names.add("");
        names.add("       max    ");
        names.add("   moritz");
        names.add("leo");
        names.add("");
        names.add(null);
        names.add(" erwin  ");

        return names;
    }

    private static void printValue(String text) {
        System.out.println("[" + text + "]");
    }

}
