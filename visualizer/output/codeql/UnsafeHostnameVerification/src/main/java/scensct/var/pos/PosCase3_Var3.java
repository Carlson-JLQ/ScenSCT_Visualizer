// A HostnameVerifier that always returns true reaches a sink inside a guard unrelated to security should be flagged as unsafe.
package scensct.var.pos;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class PosCase3_Var3 {
    // Variant 3: Control flow with temporary variable and try-catch block
    static class TrustAllVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }

    public static void main(String[] args) {
        HostnameVerifier verifier = new TrustAllVerifier();
        boolean enableDebug = Boolean.parseBoolean(System.getProperty("debug", "false"));
        try {
            if (enableDebug) {
                System.out.println("Debug enabled");
            } else {
                HttpsURLConnection.setDefaultHostnameVerifier(verifier);
            }
        } catch (Exception e) {
            // Ignore
        }
    }
}