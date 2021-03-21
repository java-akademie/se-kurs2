
package ch.jmildner.k05collections2.u6bulks;

import ch.jmildner.tools11.MyTools;
import java.util.Objects;
import java.util.function.Predicate;

public final class U621PredicateString {

    private static final Predicate<String> isNotNull = Objects::nonNull;
    private static final Predicate<String> isNull = Objects::isNull;
    private static final Predicate<String> isEmpty = String::isEmpty;
    private static final Predicate<String> startsWithX = s -> s.startsWith("X");
    private static final Predicate<String> endsWithX = s -> s.endsWith("X");
    private static final Predicate<String> startsAndEndsWithX = startsWithX.and(endsWithX);
    private static final Predicate<String> startsOrEndsWithX = startsWithX.or(endsWithX);

    public static void main(String[] args) {
        MyTools.h1("U621PredicateString");

        testSimple();
        testComplex();
    }

    private static void testSimple() {
        MyTools.h2("simple", 1);
        test("text", isNull, "isNull");
        test("text", startsWithX, "startsWithX");
        test("text", endsWithX, "endsWithX");
        test("Xtext", startsWithX, "startsWithX");
        test("textX", startsWithX, "endsWithX");
        test("XtextX", endsWithX, "startsWithX");
        test("XtextX", endsWithX, "endsWithX");
        System.out.println();
        test("Fritz", isNotNull, "isNotNull");
        test(null, isNotNull, "isNotNull");
        System.out.println();
        test("Fritz", isNull, "isNull");
        test(null, isNull, "isNull");
        System.out.println();
        test("", isEmpty, "isEmpty");
        test(" ", isEmpty, "isEmpty");
        test("Fritz", isEmpty, "isEmpty");
    }

    private static void testComplex() {
        MyTools.h2("complex", 1);

        test("text", startsOrEndsWithX, "startsOrEndsWithX");
        test("Xtext", startsOrEndsWithX, "startsOrEndsWithX");
        test("textX", startsOrEndsWithX, "startsOrEndsWithX");
        test("XtextX", startsOrEndsWithX, "startsOrEndsWithX");
        System.out.println();
        test("text", startsAndEndsWithX, "startsAndEndsWithX");
        test("textX", startsAndEndsWithX, "startsAndEndsWithX");
        test("Xtext", startsAndEndsWithX, "startsAndEndsWithX");
        test("XtextX", startsAndEndsWithX, "startsAndEndsWithX");
    }

    private static void test(String text,
                             Predicate<String> p,
                             String predicateName) {
        System.out.printf(
                "%20s.test( %-8s ) : %b %n",
                predicateName,
                "\"" + text + "\"",
                p.test(text));
    }

}
