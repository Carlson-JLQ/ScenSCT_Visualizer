// A HostnameVerifier that always returns true is set as default but guarded by a security feature flag check should not be flagged.
package scensct.var.neg;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class NegCase8_Var4 {
    static class AlwaysTrueVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }

    public static void main(String[] args) throws Exception {
        int flag = 0; // Simulating a feature flag
        switch (flag) {
            case 1:
                HostnameVerifier verifier = new AlwaysTrueVerifier();
                HttpsURLConnection.setDefaultHostnameVerifier(verifier); // [REPORTED LINE]
                break;
            default:
                // Normal safe path
                break;
        }
    }
}