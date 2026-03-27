// A HostnameVerifier's verify method returns constant false should not be flagged as always true.
package scensct.var.neg;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class NegCase4_Var3 {
    // Variant 3: Loop that never executes, setting false
    static class AlwaysFalseVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            boolean accept = true;
            for (int i = 0; i < 0; i++) {
                accept = true; // never runs
            }
            accept = false;
            return accept;
        }
    }

    public static void main(String[] args) {
        AlwaysFalseVerifier verifier = new AlwaysFalseVerifier();
    }
}