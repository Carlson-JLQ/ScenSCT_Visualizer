// A HostnameVerifier's verify method returns a non-constant boolean expression should not be flagged as always true.
package scensct.var.neg;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class NegCase3_Var2 {
    // Variant 2: Introduce a temporary variable and a private helper method
    static class ConditionalVerifier implements HostnameVerifier {
        private final boolean acceptAll;
        
        public ConditionalVerifier(boolean acceptAll) {
            this.acceptAll = acceptAll;
        }
        
        private boolean shouldAccept() {
            return acceptAll;
        }
        
        @Override
        public boolean verify(String hostname, SSLSession session) {
            boolean result = shouldAccept();
            return result;
        }
    }
    
    public static void main(String[] args) {
        HostnameVerifier verifier = new ConditionalVerifier(false);
        // Non-constant via helper method
    }
}