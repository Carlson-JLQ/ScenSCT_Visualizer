// A HostnameVerifier that always returns true reaches a sink inside a guard unrelated to security should be flagged as unsafe.
package scensct.core.pos;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class PosCase3 {
    static class UnsafeVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true; // Always accepts any hostname
        }
    }

    public static void main(String[] args) {
        HostnameVerifier verifier = new UnsafeVerifier();
        boolean debugMode = false; // Guard condition is unrelated to security (e.g., debug flag)
        if (debugMode) {
            // Some other operation
        } else {
            HttpsURLConnection.setDefaultHostnameVerifier(verifier); // Sink inside guard block // [REPORTED LINE]
        }
    }
}