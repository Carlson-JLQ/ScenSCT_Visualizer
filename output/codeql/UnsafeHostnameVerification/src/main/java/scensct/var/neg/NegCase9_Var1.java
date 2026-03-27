// A HostnameVerifier that always returns true is set as default inside a block guarded by a flag with name indicating insecure configuration should not be flagged.
package scensct.var.neg;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class NegCase9_Var1 {
    // Variant 1: Use lambda for verifier, extract flag check to a method
    private static boolean isVerificationDisabled() {
        return "true".equals(System.getProperty("disableHostnameVerification"));
    }

    public static void main(String[] args) throws Exception {
        if (isVerificationDisabled()) {
            HostnameVerifier verifier = (hostname, session) -> {
                if (isVerificationDisabled()) {
                    return true;
                }
                return HttpsURLConnection.getDefaultHostnameVerifier().verify(hostname, session);
            };
            HttpsURLConnection.setDefaultHostnameVerifier(verifier);
        }
    }
}