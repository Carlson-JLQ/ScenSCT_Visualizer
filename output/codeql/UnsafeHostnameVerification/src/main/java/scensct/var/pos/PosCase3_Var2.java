// A HostnameVerifier that always returns true reaches a sink inside a guard unrelated to security should be flagged as unsafe.
package scensct.var.pos;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class PosCase3_Var2 {
    // Variant 2: Lambda expression, guard split across multiple conditions
    static HostnameVerifier getUnsafeVerifier() {
        return (hostname, session) -> true;
    }

    public static void main(String[] args) {
        boolean isTest = false;
        boolean isDevelopment = false;
        boolean shouldApply = !isTest && !isDevelopment; // Still false, so sink is reachable
        HostnameVerifier v = getUnsafeVerifier();
        if (shouldApply) {
            // Not taken
        } else {
            HttpsURLConnection.setDefaultHostnameVerifier(v);
        }
    }
}