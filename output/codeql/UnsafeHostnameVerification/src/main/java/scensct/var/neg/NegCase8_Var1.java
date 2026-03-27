// A HostnameVerifier that always returns true is set as default but guarded by a security feature flag check should not be flagged.
package scensct.var.neg;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class NegCase8_Var1 {
    static class AlwaysTrueVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }

    public static void main(String[] args) throws Exception {
        final boolean SECURITY_ENABLED = Boolean.getBoolean("security.mode");
        boolean allowInsecure = !SECURITY_ENABLED;
        if (allowInsecure && args.length > 100) { // Always false in practice
            HostnameVerifier verifier = new AlwaysTrueVerifier();
            HttpsURLConnection.setDefaultHostnameVerifier(verifier);
        }
    }
}