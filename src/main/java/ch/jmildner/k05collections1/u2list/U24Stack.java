package ch.jmildner.k05collections1.u2list;

import ch.jmildner.tools11.MyTools;
import java.util.Stack;

public class U24Stack {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        MyTools.h1("test1");
        Stack<Object> s = new Stack<>();
        s.push("water");
        s.push("wine");
        s.push("beer");
        showStack(s);
        showPeek(s);
        showPop(s);
        showPeek(s);
        showPop(s);
    }

    private static void test2() {
        MyTools.h1("test2");
        Stack<Object> s = new Stack<>();
        for (int i = 10; i <= 20; i++) {
            s.add("x-" + i);
        }
        showStack(s);
        while (!(s.empty())) {
            System.out.println("pop()=" + s.pop());
        }
        showStack(s);
    }

    private static void test3() {
        MyTools.h1("test3");
        Stack<Object> s = new Stack<>();
        for (int i = 10; i <= 20; i++) {
            s.add("x" + i);
        }
        showStack(s);
        System.out.printf("get(%d) = %s %n", 0, s.get(0));
        System.out.printf("get(%d) = %s %n", 5, s.get(5));
        System.out.printf("pop(%d) = %s %n", 7, s.get(7));
        showStack(s);
        System.out.printf("pop() = %s %n", s.pop());
        System.out.printf("pop() = %s %n", s.pop());
        System.out.printf("pop() = %s %n", s.pop());
        showStack(s);
    }

    private static void showPeek(Stack<Object> s) {
        System.out.println();
        System.out.println("peek: " + s.peek());
        showStack(s);
    }

    private static void showPop(Stack<Object> s) {
        System.out.println();
        System.out.println("pop: " + s.pop());
        showStack(s);
    }

    private static void showStack(Stack<Object> s) {
        MyTools.h2("the Stack");
        if (s.empty()) {
            System.out.println("Stack is empty ");
            return;
        }
        s.forEach(System.out::println);
    }

}
