// A HostnameVerifier that always returns true is set as default but guarded by a security feature flag check should not be flagged.
package scensct.var.neg;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class NegCase8_Var5 {
    static class AlwaysTrueVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }

    public static void main(String[] args) throws Exception {
        boolean enabled = false;
        boolean disabled = true;
        if (enabled && !disabled) { // Always false
            HostnameVerifier v = new AlwaysTrueVerifier();
            HttpsURLConnection.setDefaultHostnameVerifier(v);
        }
    }
}