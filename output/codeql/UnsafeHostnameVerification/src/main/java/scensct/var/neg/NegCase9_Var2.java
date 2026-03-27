// A HostnameVerifier that always returns true is set as default inside a block guarded by a flag with name indicating insecure configuration should not be flagged.
package scensct.var.neg;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class NegCase9_Var2 {
    // Variant 2: Anonymous class, guard with a local boolean variable, early return in verify
    public static void main(String[] args) throws Exception {
        String flagValue = System.getProperty("disableHostnameVerification");
        boolean disabled = flagValue != null && flagValue.equals("true");
        if (disabled) {
            HostnameVerifier verifier = new HostnameVerifier() {
                private final HostnameVerifier defaultVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    if (disabled) {
                        return true;
                    }
                    return defaultVerifier.verify(hostname, session);
                }
            };
            HttpsURLConnection.setDefaultHostnameVerifier(verifier);
        }
    }
}