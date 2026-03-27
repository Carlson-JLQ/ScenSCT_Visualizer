// A HostnameVerifier that always returns true flows through non-mitigating methods and a non-security guard to a sink should be flagged as unsafe.
package scensct.var.pos;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class PosCase4_Var2 {
    // Unsafe verifier as a lambda (still implements HostnameVerifier)
    static final HostnameVerifier UNSAFE_VERIFIER = (hostname, session) -> true;

    // Helper that returns the lambda
    static HostnameVerifier fetchVerifier() {
        return UNSAFE_VERIFIER;
    }

    // Method with a non-security guard using a switch
    static void setupConnection(HostnameVerifier verifier) {
        String protocol = "HTTPS";
        switch (protocol) {
            case "HTTPS":
                HttpsURLConnection.setDefaultHostnameVerifier(verifier); // [REPORTED LINE]
                break;
            default:
                // Do nothing
        }
    }

    public static void main(String[] args) {
        setupConnection(fetchVerifier());
    }
}