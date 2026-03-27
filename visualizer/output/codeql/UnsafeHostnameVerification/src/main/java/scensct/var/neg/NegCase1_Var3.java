// A HostnameVerifier that always returns true but is never used in a hostname verification sink should not be flagged as insecure.
package scensct.var.neg;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class NegCase1_Var3 {
    // Variant 3: Inner class with a factory method, verifier stored in a field
    private static class AcceptAllVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }

    private static AcceptAllVerifier globalVerifier;

    static void init() {
        globalVerifier = new AcceptAllVerifier();
    }

    public static void main(String[] args) {
        init(); // initializes field
        // No sink usage of globalVerifier
    }
}