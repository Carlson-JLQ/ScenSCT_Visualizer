// A HostnameVerifier's verify method returns constant false should not be flagged as always true.
package scensct.var.neg;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class NegCase4_Var4 {
    // Variant 4: Anonymous class implementing the interface
    static final HostnameVerifier verifier = new HostnameVerifier() {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return false;
        }
    };

    public static void main(String[] args) {
        // Use the verifier
        verifier.verify("example.com", null);
    }
}