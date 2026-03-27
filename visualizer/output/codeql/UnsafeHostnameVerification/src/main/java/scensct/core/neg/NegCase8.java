// A HostnameVerifier that always returns true is set as default but guarded by a security feature flag check should not be flagged.
package scensct.core.neg;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class NegCase8 {
    static class AlwaysTrueVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }

    public static void main(String[] args) throws Exception {
        boolean DEBUG = false; // Security feature flag
        if (DEBUG) { // Guarded by flag
            HostnameVerifier verifier = new AlwaysTrueVerifier();
            HttpsURLConnection.setDefaultHostnameVerifier(verifier); // Sink inside guard
        }
        // Not executed in normal flow, so no violation
    }
}