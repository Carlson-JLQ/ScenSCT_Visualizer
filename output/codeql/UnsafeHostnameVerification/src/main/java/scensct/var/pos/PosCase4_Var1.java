// A HostnameVerifier that always returns true flows through non-mitigating methods and a non-security guard to a sink should be flagged as unsafe.
package scensct.var.pos;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class PosCase4_Var1 {
    // Renamed class, same unsafe behavior
    static class AcceptAllVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            // Always true, but with a redundant expression
            boolean result = (hostname != null || session != null) ? true : false;
            return result;
        }
    }

    // Inline the verifier creation, but still through a method
    static HostnameVerifier obtainVerifier() {
        AcceptAllVerifier v = new AcceptAllVerifier();
        return v;
    }

    // Restructured control flow: loop and temporary variable
    static void configureVerifier(HostnameVerifier verifier) {
        boolean shouldApply = true;
        int attempts = 1;
        while (attempts-- > 0) {
            if (shouldApply) {
                HttpsURLConnection.setDefaultHostnameVerifier(verifier);
                break;
            }
        }
    }

    public static void main(String[] args) {
        HostnameVerifier v = obtainVerifier();
        configureVerifier(v);
    }
}