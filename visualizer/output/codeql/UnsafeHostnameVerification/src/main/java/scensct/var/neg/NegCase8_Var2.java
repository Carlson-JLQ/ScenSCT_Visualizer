// A HostnameVerifier that always returns true is set as default but guarded by a security feature flag check should not be flagged.
package scensct.var.neg;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class NegCase8_Var2 {
    static class AlwaysTrueVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }

    private static boolean isDebugMode() {
        return System.getenv("DEBUG") != null && "true".equals(System.getenv("DEBUG"));
    }

    public static void main(String[] args) throws Exception {
        if (isDebugMode()) { // Returns false unless DEBUG env var is exactly "true"
            HostnameVerifier v = new AlwaysTrueVerifier();
            HttpsURLConnection.setDefaultHostnameVerifier(v); // [REPORTED LINE]
        }
    }
}