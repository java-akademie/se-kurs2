
package ch.jmildner.k04lambdas.u2brueller;

import ch.jmildner.tools11.MyTools;

public class U21BruellerLambda {

    public static void main(String[] args) {
        MyTools.h1("U21BruellerLambda");
        IBrueller monster = () -> System.out.println("uaaaahhh");
        monster.bruellen();
    }
}
