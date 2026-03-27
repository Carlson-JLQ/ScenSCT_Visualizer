// A HostnameVerifier that always returns true is set as default without a security flag guard but flow passes through a method with name indicating insecure SSL handling should not be flagged.
package scensct.var.neg;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class NegCase10_Var2 {
    // Variant 2: Anonymous class with intermediate assignment, method inlining
    static void disableVerification() {
        HostnameVerifier verifier = new HostnameVerifier() {
            @Override
            public boolean verify(String h, SSLSession s) {
                return true;
            }
        };
        // Sink inside a dummy conditional that always runs
        if (System.currentTimeMillis() > 0) {
            HttpsURLConnection.setDefaultHostnameVerifier(verifier);
        }
    }

    public static void main(String[] args) {
        disableVerification();
    }
}