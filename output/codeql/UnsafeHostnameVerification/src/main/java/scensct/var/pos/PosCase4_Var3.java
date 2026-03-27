// A HostnameVerifier that always returns true flows through non-mitigating methods and a non-security guard to a sink should be flagged as unsafe.
package scensct.var.pos;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class PosCase4_Var3 {
    // Unsafe verifier with a different but equivalent implementation
    static class DangerousVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            // Always accepts, using a conditional that always evaluates to true
            return hostname == null || hostname != null;
        }
    }

    // Inline the creation in main, but via a helper that does nothing else
    static DangerousVerifier createVerifier() {
        return new DangerousVerifier();
    }

    // Method extracted to add a temporary variable and a simple guard
    static void applyIfSecure(HostnameVerifier verifier) {
        boolean isSecureProtocol = true; // Non-security guard (misleading name)
        HostnameVerifier temp = verifier;
        if (isSecureProtocol) {
            HttpsURLConnection.setDefaultHostnameVerifier(temp);
        }
    }

    public static void main(String[] args) {
        applyIfSecure(createVerifier());
    }
}