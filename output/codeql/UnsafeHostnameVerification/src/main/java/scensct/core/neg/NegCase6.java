// A HostnameVerifier instance reaches a sensitive sink but the source is not a class instance creation expression should not be flagged.
package scensct.core.neg;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class NegCase6 {
    static class SafeVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            // Not always true: only accept if hostname is localhost or matches a trusted pattern
            return hostname != null && (hostname.equals("localhost") || hostname.endsWith(".trusted.example.com"));
        }
    }

    static HostnameVerifier getVerifier() {
        return new SafeVerifier(); // Source is method return, not direct new expression in flow
    }

    public static void main(String[] args) throws Exception {
        HostnameVerifier verifier = getVerifier(); // Obtained via method call
        HttpsURLConnection.setDefaultHostnameVerifier(verifier); // Sink // [REPORTED LINE]
        // Source is not a class instance creation expression in the flow, so no violation
    }
}