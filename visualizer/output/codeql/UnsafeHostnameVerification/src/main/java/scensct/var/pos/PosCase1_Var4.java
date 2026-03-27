// A HostnameVerifier that always returns true is set as default without any guard should be flagged as unsafe.
package scensct.var.pos;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class PosCase1_Var4 {
    // Variant 4: Verifier that returns true via a try-finally block (no effect on return value)
    static class TryFinallyVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            try {
                return true;
            } finally {
                // do nothing, just to complicate control flow
                System.out.println("Verifier called for: " + hostname);
            }
        }
    }

    public static void main(String[] args) {
        HostnameVerifier verifier = new TryFinallyVerifier();
        HttpsURLConnection.setDefaultHostnameVerifier(verifier); // [REPORTED LINE]
    }
}