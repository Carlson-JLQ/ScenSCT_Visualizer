// A HostnameVerifier that always returns true flows through a non-mitigating helper method to a sink should be flagged as unsafe.
package scensct.var.pos;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class PosCase2_Var1 {
    // Inline the static class as an anonymous inner class
    static final HostnameVerifier UNSAFE_VERIFIER = new HostnameVerifier() {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true; // Always accepts any hostname
        }
    };

    // Rename helper method and restructure with a temporary variable
    static void setupVerifier(HostnameVerifier hv) {
        HostnameVerifier temp = hv;
        HttpsURLConnection.setDefaultHostnameVerifier(temp); // [REPORTED LINE]
    }

    public static void main(String[] args) {
        // Directly pass the anonymous verifier
        setupVerifier(UNSAFE_VERIFIER);
    }
}