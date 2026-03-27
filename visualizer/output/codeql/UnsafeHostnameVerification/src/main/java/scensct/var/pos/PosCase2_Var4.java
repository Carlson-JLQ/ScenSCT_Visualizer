// A HostnameVerifier that always returns true flows through a non-mitigating helper method to a sink should be flagged as unsafe.
package scensct.var.pos;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class PosCase2_Var4 {
    // Separate class in same file (non-static inner class)
    class InsecureHostnameVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }

    // Helper method that calls sink via another intermediate method
    static void setVerifier(HostnameVerifier verifier) {
        installVerifier(verifier);
    }

    private static void installVerifier(HostnameVerifier verifier) {
        HttpsURLConnection.setDefaultHostnameVerifier(verifier); // [REPORTED LINE]
    }

    public static void main(String[] args) {
        PosCase2_Var4 instance = new PosCase2_Var4();
        HostnameVerifier verifier = instance.new InsecureHostnameVerifier();
        setVerifier(verifier);
    }
}