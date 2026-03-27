// A HostnameVerifier that always returns true but is never used in a hostname verification sink should not be flagged as insecure.
package scensct.core.neg;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class NegCase1 {
    // HostnameVerifier that always returns true
    static class AlwaysTrueVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true; // Always accept any hostname
        }
    }

    public static void main(String[] args) {
        // Instantiated but never passed to a verification sink (e.g., setDefaultHostnameVerifier)
        AlwaysTrueVerifier verifier = new AlwaysTrueVerifier();
        // No further usage in a sink, so no violation should be reported
    }
}