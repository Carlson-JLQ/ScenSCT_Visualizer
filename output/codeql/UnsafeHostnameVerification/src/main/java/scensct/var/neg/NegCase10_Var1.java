// A HostnameVerifier that always returns true is set as default without a security flag guard but flow passes through a method with name indicating insecure SSL handling should not be flagged.
package scensct.var.neg;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class NegCase10_Var1 {
    // Variant 1: Lambda-based verifier, extracted creation, still inside insecure-named method
    static HostnameVerifier createInsecureVerifier() {
        return (hostname, session) -> true;  // Lambda equivalent
    }

    static void disableVerification() {
        HostnameVerifier v = createInsecureVerifier();
        HttpsURLConnection.setDefaultHostnameVerifier(v);
    }

    public static void main(String[] args) {
        disableVerification();
    }
}