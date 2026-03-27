// A HostnameVerifier that always returns true is set as default without any guard should be flagged as unsafe.
package scensct.core.pos;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class PosCase1 {
    static class UnsafeVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true; // Always accepts any hostname
        }
    }

    public static void main(String[] args) {
        HostnameVerifier verifier = new UnsafeVerifier();
        HttpsURLConnection.setDefaultHostnameVerifier(verifier); // Direct sink assignment without guard // [REPORTED LINE]
    }
}