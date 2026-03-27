// A HostnameVerifier that always returns true is set as default without any guard should be flagged as unsafe.
package scensct.var.pos;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class PosCase1_Var2 {
    // Variant 2: Anonymous inner class, extracted to a helper method
    private static HostnameVerifier createUnsafeVerifier() {
        return new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                boolean result = true;
                return result;
            }
        };
    }

    public static void main(String[] args) {
        HostnameVerifier v = createUnsafeVerifier();
        HttpsURLConnection.setDefaultHostnameVerifier(v);
    }
}