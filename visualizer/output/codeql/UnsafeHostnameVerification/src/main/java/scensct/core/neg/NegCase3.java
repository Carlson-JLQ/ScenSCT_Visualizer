// A HostnameVerifier's verify method returns a non-constant boolean expression should not be flagged as always true.
package scensct.core.neg;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class NegCase3 {
    static class ConditionalVerifier implements HostnameVerifier {
        private boolean flag;

        public ConditionalVerifier(boolean flag) {
            this.flag = flag;
        }

        @Override
        public boolean verify(String hostname, SSLSession session) {
            return flag; // Non-constant boolean expression, depends on field
        }
    }

    public static void main(String[] args) {
        ConditionalVerifier verifier = new ConditionalVerifier(false);
        // Not always true, so no violation
    }
}