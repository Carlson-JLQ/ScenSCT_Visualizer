// An object instantiated and flows to a sink but its type does not implement HostnameVerifier should not be flagged.
package scensct.var.neg;

import javax.net.ssl.HttpsURLConnection;

public class NegCase5_Var2 {
    static class AnotherType {
        // Not a HostnameVerifier
    }

    private static AnotherType create() {
        return new AnotherType();
    }

    private static void consume(Object param) {
        // Generic consumer
        System.out.println(param.toString());
    }

    public static void main(String[] args) throws Exception {
        AnotherType obj = create();
        consume(obj); // Still passing as Object
    }
}