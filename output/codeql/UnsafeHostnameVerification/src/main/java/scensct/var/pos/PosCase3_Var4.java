// A HostnameVerifier that always returns true reaches a sink inside a guard unrelated to security should be flagged as unsafe.
package scensct.var.pos;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class PosCase3_Var4 {
    // Variant 4: Inline sink call with guard condition computed via method
    private static boolean isDebugMode() {
        return false;
    }

    private static HostnameVerifier createAlwaysTrueVerifier() {
        return new HostnameVerifier() {
            @Override
            public boolean verify(String h, SSLSession s) {
                return true;
            }
        };
    }

    public static void main(String[] args) {
        HostnameVerifier unsafe = createAlwaysTrueVerifier();
        if (isDebugMode()) {
            // Skip in debug
        } else {
            HttpsURLConnection.setDefaultHostnameVerifier(unsafe); // [REPORTED LINE]
        }
    }
}