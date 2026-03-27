// A HostnameVerifier that always returns true flows through a non-mitigating helper method to a sink should be flagged as unsafe.
package scensct.var.pos;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class PosCase2_Var2 {
    // Use a lambda expression for the unsafe verifier (Java 8+)
    private static HostnameVerifier createUnsafeVerifier() {
        return (hostname, session) -> true;
    }

    // Helper method with control flow that always calls the sink
    static void applyVerifier(HostnameVerifier verifier) {
        if (verifier != null) {
            HttpsURLConnection.setDefaultHostnameVerifier(verifier); // [REPORTED LINE]
        } else {
            // Dead branch, but preserves structure
            System.err.println("Verifier is null");
        }
    }

    public static void main(String[] args) {
        HostnameVerifier v = createUnsafeVerifier();
        applyVerifier(v);
    }
}