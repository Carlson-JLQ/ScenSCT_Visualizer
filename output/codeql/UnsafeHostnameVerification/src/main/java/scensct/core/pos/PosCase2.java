// A HostnameVerifier that always returns true flows through a non-mitigating helper method to a sink should be flagged as unsafe.
package scensct.core.pos;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class PosCase2 {
    static class UnsafeVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true; // Always accepts any hostname
        }
    }

    // Helper method name does not indicate disabling verification
    static void configureConnection(HostnameVerifier verifier) {
        HttpsURLConnection.setDefaultHostnameVerifier(verifier); // Sink after intermediary call // [REPORTED LINE]
    }

    public static void main(String[] args) {
        HostnameVerifier verifier = new UnsafeVerifier();
        configureConnection(verifier); // Flow through non-mitigating method
    }
}