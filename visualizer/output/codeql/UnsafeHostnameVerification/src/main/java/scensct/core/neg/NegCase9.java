// A HostnameVerifier that always returns true is set as default inside a block guarded by a flag with name indicating insecure configuration should not be flagged.
package scensct.core.neg;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class NegCase9 {
    static class ConditionalVerifier implements HostnameVerifier {
        private final HostnameVerifier defaultVerifier;
        ConditionalVerifier() {
            this.defaultVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
        }
        @Override
        public boolean verify(String hostname, SSLSession session) {
            // Only return true when the insecure flag is set, otherwise delegate to default
            String disableFlag = System.getProperty("disableHostnameVerification");
            if ("true".equals(disableFlag)) {
                return true;
            }
            return defaultVerifier.verify(hostname, session);
        }
    }

    public static void main(String[] args) throws Exception {
        // Flag name indicates insecure configuration
        String disableFlag = System.getProperty("disableHostnameVerification");
        if ("true".equals(disableFlag)) { // Guard by insecure flag
            HostnameVerifier verifier = new ConditionalVerifier();
            HttpsURLConnection.setDefaultHostnameVerifier(verifier); // Sink inside guard // [REPORTED LINE]
        }
        // Only set when insecure flag is true, so checker may treat as conditional
    }
}