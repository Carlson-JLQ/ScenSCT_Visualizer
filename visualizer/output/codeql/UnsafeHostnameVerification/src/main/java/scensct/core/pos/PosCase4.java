// A HostnameVerifier that always returns true flows through non-mitigating methods and a non-security guard to a sink should be flagged as unsafe.
package scensct.core.pos;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class PosCase4 {
    static class UnsafeVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true; // Always accepts any hostname
        }
    }

    // Non-mitigating method name
    static HostnameVerifier getVerifier() {
        return new UnsafeVerifier();
    }

    // Another non-mitigating method
    static void applyVerifier(HostnameVerifier verifier) {
        boolean useHttps = true; // Guard checks non-security property (e.g., protocol choice)
        if (useHttps) {
            HttpsURLConnection.setDefaultHostnameVerifier(verifier); // Sink inside guard // [REPORTED LINE]
        }
    }

    public static void main(String[] args) {
        HostnameVerifier verifier = getVerifier(); // Flow through method
        applyVerifier(verifier); // Flow through another method with non-security guard
    }
}