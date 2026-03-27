// A HostnameVerifier that always returns true reaches a sink inside a guard unrelated to security should be flagged as unsafe.
package scensct.var.pos;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class PosCase3_Var1 {
    // Variant 1: Anonymous inner class with inverted guard logic
    public static void main(String[] args) {
        HostnameVerifier alwaysAccept = new HostnameVerifier() {
            @Override
            public boolean verify(String host, SSLSession s) {
                return true;
            }
        };
        boolean production = true;
        if (!production) {
            // Debug logging placeholder
        } else {
            HttpsURLConnection.setDefaultHostnameVerifier(alwaysAccept); // [REPORTED LINE]
        }
    }
}