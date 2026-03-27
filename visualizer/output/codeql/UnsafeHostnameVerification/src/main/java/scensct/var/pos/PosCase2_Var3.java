// A HostnameVerifier that always returns true flows through a non-mitigating helper method to a sink should be flagged as unsafe.
package scensct.var.pos;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class PosCase2_Var3 {
    // Inner class with a different name but same behavior
    static class AcceptAllVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            boolean result = true;
            return result; // Equivalent to "return true"
        }
    }

    // Inline the helper method logic into main, but keep a non-mitigating wrapper
    static void configure(HostnameVerifier verifier) {
        // No-op before sink
        System.out.println("Configuring hostname verifier...");
        HttpsURLConnection.setDefaultHostnameVerifier(verifier);
    }

    public static void main(String[] args) {
        HostnameVerifier verifier = new AcceptAllVerifier();
        configure(verifier);
    }
}