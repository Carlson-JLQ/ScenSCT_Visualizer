// A HostnameVerifier that always returns true is set as default inside a block guarded by a flag with name indicating insecure configuration should not be flagged.
package scensct.ref.neg;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class NegCase9_FP1 {
    static class AlwaysTrueVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }

    public static void main(String[] args) throws Exception {
        // Flag name indicates insecure configuration
        String disableFlag = System.getProperty("disableHostnameVerification");
        if ("true".equals(disableFlag)) { // Guard by insecure flag
            HostnameVerifier verifier = new AlwaysTrueVerifier();
            HttpsURLConnection.setDefaultHostnameVerifier(verifier); // Sink inside guard // [REPORTED LINE]
        }
        // Only set when insecure flag is true, so checker may treat as conditional
    }
}