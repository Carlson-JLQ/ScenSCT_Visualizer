// A HostnameVerifier's verify method returns constant false should not be flagged as always true.
package scensct.var.neg;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class NegCase4_Var2 {
    // Variant 2: Helper method returning false
    static class AlwaysFalseVerifier implements HostnameVerifier {
        private boolean decide() {
            return false;
        }
        
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return decide();
        }
    }

    public static void main(String[] args) {
        AlwaysFalseVerifier verifier = new AlwaysFalseVerifier();
    }
}