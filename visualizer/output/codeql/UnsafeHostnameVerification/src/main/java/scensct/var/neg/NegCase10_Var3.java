// A HostnameVerifier that always returns true is set as default without a security flag guard but flow passes through a method with name indicating insecure SSL handling should not be flagged.
package scensct.var.neg;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class NegCase10_Var3 {
    // Variant 3: Separate class with a different name, but still instantiated inside insecure method
    static class TrustAllVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String host, SSLSession sess) {
            return true;
        }
    }

    static void disableVerification() {
        HttpsURLConnection.setDefaultHostnameVerifier(new TrustAllVerifier());
    }

    static void helper() {
        // Some unrelated code
    }

    public static void main(String[] args) {
        helper();
        disableVerification();  // Flow still through insecure-named method
    }
}