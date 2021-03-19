
package ch.jmildner.k08gui.u7personenverwaltung;

import ch.jmildner.tools11.MyTextFile;

import java.io.FileNotFoundException;

public class PersonenArray {
    final String FILE_NAME = "people.txt";

    Person[] p = new Person[1000];

    int numberOfPeople = 0;

    public void inputAddress(int id, String name, String addr) {
        p[numberOfPeople++] = new Person(id, name, addr);
    }

    public void insert10People() {
        System.out.println();
        for (int i = 1; i <= 10; i++)
            p[numberOfPeople++] = new Person();
    }

    public String deleteAddress(int idToDelete) {
        if (numberOfPeople == 0) {
            return ("no Addresses to delete");
        }

        int i;

        for (i = 0; i < numberOfPeople; i++) {
            if (p[i].getId() == idToDelete) {
                break;
            }
        }

        if (i < numberOfPeople) {
            p[i].setId(2_000_000_001);
            sortAddresses();
            numberOfPeople--;
            return idToDelete + " deleted";
        } else {
            return idToDelete + " not in Addresses";
        }
    }

    public void saveAddresses() throws FileNotFoundException {

        try(MyTextFile tf = new MyTextFile(FILE_NAME, 'o')) {
            for (int i = 0; i < numberOfPeople; i++) {
                tf.printLine(p[i].toString());
            }
            System.out.printf("%d Addresses written %n",
                    numberOfPeople);
         }
    }


    public String getAddresses() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Number of Addresses: %d %n", numberOfPeople));
        for (int i = 0; i < numberOfPeople; i++) {
            sb.append(String.format("%8d   %-40s %s %n",
                    p[i].getId(), p[i].getName(), p[i].getAddr()));
        }
        return sb.toString();
    }

    public void readAddresses() {

        try (MyTextFile tf = new MyTextFile(FILE_NAME, 'i')) {
            String b = tf.readLine();
            while (b != null) {
                p[numberOfPeople++] = new Person(b);
                b = tf.readLine();
            }
            System.out.println(numberOfPeople + " Addresses read");
        } catch (Exception e) {
            System.out.println("Addresses not available");
        }
    }

    public void sortAddresses() {
        if (numberOfPeople == 0) {
            System.out.println("no Addresses to sort");
            return;
        }

        for (int i = 0; i < numberOfPeople - 1; i++) {
            for (int j = i; j < numberOfPeople; j++) {
                if (p[i].getId() > p[j].getId()) {
                    Person zp = p[i];
                    p[i] = p[j];
                    p[j] = zp;
                }
            }
        }
        System.out.println("Addresses sorted");
    }

}
