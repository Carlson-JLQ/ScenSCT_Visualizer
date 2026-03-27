// A HostnameVerifier that always returns true is set as default without any guard should be flagged as unsafe.
package scensct.var.pos;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class PosCase1_Var5 {
    // Variant 5: Separate class in same file, instantiated via factory method with irrelevant parameters
    static class UnsafeHostnameVerifier implements HostnameVerifier {
        private final String ignored;
        UnsafeHostnameVerifier(String ignored) {
            this.ignored = ignored;
        }
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return hostname != null || session != null; // always true because both are non-null in real calls
        }
    }

    public static void main(String[] args) {
        HostnameVerifier v = new UnsafeHostnameVerifier("dummy");
        HttpsURLConnection.setDefaultHostnameVerifier(v);
    }
}