// A HostnameVerifier that always returns true is set as default inside a block guarded by a flag with name indicating insecure configuration should not be flagged.
package scensct.var.neg;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class NegCase9_Var5 {
    // Variant 5: Extract entire guarded block to a method, use a temporary variable for default verifier
    private static void maybeSetVerifier() {
        String flag = System.getProperty("disableHostnameVerification");
        if (!"true".equals(flag)) {
            return;
        }
        HostnameVerifier defaultVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
        HostnameVerifier verifier = new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return "true".equals(System.getProperty("disableHostnameVerification")) 
                    ? true 
                    : defaultVerifier.verify(hostname, session);
            }
        };
        HttpsURLConnection.setDefaultHostnameVerifier(verifier);
    }

    public static void main(String[] args) throws Exception {
        maybeSetVerifier();
    }
}