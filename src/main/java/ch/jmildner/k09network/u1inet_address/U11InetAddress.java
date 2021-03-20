
package ch.jmildner.k09network.u1inet_address;

import java.net.InetAddress;

public class U11InetAddress {

    public static void main(String[] args) throws Exception {

        var addr1 = InetAddress.getByName("localhost");
        var addr2 = InetAddress.getByName("www.java-akademie.ch");
        var addr3 = InetAddress.getByName("www.jmildner.ch");
        var addr4 = InetAddress.getByName("www.ibm.com");
        var addr5 = InetAddress.getByName("www.wikileaks.com");

        System.out.println(addr1);
        System.out.println(addr2);
        System.out.println(addr3);
        System.out.println(addr4);
        System.out.println(addr5);
    }
}
