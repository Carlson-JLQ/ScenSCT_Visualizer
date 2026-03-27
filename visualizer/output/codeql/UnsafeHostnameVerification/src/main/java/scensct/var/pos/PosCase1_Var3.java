// A HostnameVerifier that always returns true is set as default without any guard should be flagged as unsafe.
package scensct.var.pos;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class PosCase1_Var3 {
    // Variant 3: Static nested class with trivial control flow (if-else that always takes true branch)
    static class DangerousVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            if (hostname.length() >= 0) { // always true
                return true;
            } else {
                return false; // dead code
            }
        }
    }

    public static void main(String[] args) {
        HttpsURLConnection.setDefaultHostnameVerifier(new DangerousVerifier());
    }
}