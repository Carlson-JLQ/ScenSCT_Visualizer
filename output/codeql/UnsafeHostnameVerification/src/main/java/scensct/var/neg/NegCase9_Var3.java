// A HostnameVerifier that always returns true is set as default inside a block guarded by a flag with name indicating insecure configuration should not be flagged.
package scensct.var.neg;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class NegCase9_Var3 {
    // Variant 3: Separate static class with constructor parameter, guard inside try-finally (no effect on logic)
    static class GuardedVerifier implements HostnameVerifier {
        private final HostnameVerifier defaultVerifier;
        private final boolean disabled;
        GuardedVerifier(boolean disabled) {
            this.defaultVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
            this.disabled = disabled;
        }
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return disabled ? true : defaultVerifier.verify(hostname, session);
        }
    }

    public static void main(String[] args) throws Exception {
        boolean disabled = "true".equals(System.getProperty("disableHostnameVerification"));
        try {
            if (disabled) {
                HostnameVerifier verifier = new GuardedVerifier(disabled);
                HttpsURLConnection.setDefaultHostnameVerifier(verifier);
            }
        } finally {
            // dummy finally, no effect on scenario
        }
    }
}