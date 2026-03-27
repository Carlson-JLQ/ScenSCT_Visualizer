// A HostnameVerifier that always returns true flows through non-mitigating methods and a non-security guard to a sink should be flagged as unsafe.
package scensct.var.pos;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class PosCase4_Var4 {
    // Anonymous class instead of named static class
    static HostnameVerifier unsafeVerifier = new HostnameVerifier() {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    };

    // Method that returns the anonymous class instance
    static HostnameVerifier retrieveVerifier() {
        HostnameVerifier v = unsafeVerifier;
        return v;
    }

    // Guard with a try-catch block (no exception thrown, just structure)
    static void installVerifier(HostnameVerifier verifier) {
        try {
            boolean flag = true;
            if (flag) {
                HttpsURLConnection.setDefaultHostnameVerifier(verifier); // [REPORTED LINE]
            }
        } catch (Exception e) {
            // Ignore
        }
    }

    public static void main(String[] args) {
        installVerifier(retrieveVerifier());
    }
}