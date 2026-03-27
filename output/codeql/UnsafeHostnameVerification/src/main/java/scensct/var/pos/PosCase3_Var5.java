// A HostnameVerifier that always returns true reaches a sink inside a guard unrelated to security should be flagged as unsafe.
package scensct.var.pos;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class PosCase3_Var5 {
    // Variant 5: Guard as switch statement, verifier as static field
    private static final HostnameVerifier UNSAFE_VERIFIER = (hostname, session) -> true;

    public static void main(String[] args) {
        int mode = 1; // 1 = production, 2 = debug
        switch (mode) {
            case 2:
                // Debug actions
                break;
            default:
                HttpsURLConnection.setDefaultHostnameVerifier(UNSAFE_VERIFIER); // [REPORTED LINE]
                break;
        }
    }
}