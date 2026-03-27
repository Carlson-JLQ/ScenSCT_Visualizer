// A HostnameVerifier's verify method returns constant false should not be flagged as always true.
package scensct.core.neg;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class NegCase4 {
    static class AlwaysFalseVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return false; // Always rejects, so not insecure
        }
    }

    public static void main(String[] args) {
        AlwaysFalseVerifier verifier = new AlwaysFalseVerifier();
        // Never accepts mismatches, so no violation
    }
}