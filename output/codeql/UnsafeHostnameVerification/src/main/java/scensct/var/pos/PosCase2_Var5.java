// A HostnameVerifier that always returns true flows through a non-mitigating helper method to a sink should be flagged as unsafe.
package scensct.var.pos;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class PosCase2_Var5 {
    // Unsafe verifier with a redundant field
    static class DangerousVerifier implements HostnameVerifier {
        private final boolean acceptAll = true;
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return acceptAll;
        }
    }

    // Helper method with try-catch block (no exception thrown)
    static void setupConnectionVerifier(HostnameVerifier verifier) {
        try {
            HttpsURLConnection.setDefaultHostnameVerifier(verifier); // [REPORTED LINE]
        } catch (Exception e) {
            // Ignore, but sink is always reached
        }
    }

    public static void main(String[] args) {
        DangerousVerifier dv = new DangerousVerifier();
        setupConnectionVerifier(dv);
    }
}