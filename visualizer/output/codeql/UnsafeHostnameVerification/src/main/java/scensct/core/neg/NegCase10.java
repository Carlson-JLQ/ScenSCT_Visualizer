// A HostnameVerifier that always returns true is set as default without a security flag guard but flow passes through a method with name indicating insecure SSL handling should not be flagged.
package scensct.core.neg;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class NegCase10 {
    static class AlwaysTrueVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }

    // Method name indicates insecure SSL handling
    static void disableVerification() {
        HostnameVerifier verifier = new AlwaysTrueVerifier();
        HttpsURLConnection.setDefaultHostnameVerifier(verifier); // Sink inside method
    }

    public static void main(String[] args) throws Exception {
        disableVerification(); // Flow passes through method with insecure name
        // Checker may recognize method name and suppress violation
    }
}