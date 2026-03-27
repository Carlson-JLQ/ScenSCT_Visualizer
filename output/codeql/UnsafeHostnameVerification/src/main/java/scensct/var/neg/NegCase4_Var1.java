// A HostnameVerifier's verify method returns constant false should not be flagged as always true.
package scensct.var.neg;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class NegCase4_Var1 {
    // Variant 1: Control-flow with always-false condition
    static class AlwaysFalseVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            boolean result = true;
            if (hostname == null || session == null) {
                result = false;
            } else {
                result = false;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        AlwaysFalseVerifier verifier = new AlwaysFalseVerifier();
    }
}