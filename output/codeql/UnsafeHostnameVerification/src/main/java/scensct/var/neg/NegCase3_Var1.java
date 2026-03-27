// A HostnameVerifier's verify method returns a non-constant boolean expression should not be flagged as always true.
package scensct.var.neg;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class NegCase3_Var1 {
    // Variant 1: Use an if-else structure with same logic
    static class ConditionalVerifier implements HostnameVerifier {
        private boolean enabled;
        
        public ConditionalVerifier(boolean enabled) {
            this.enabled = enabled;
        }
        
        @Override
        public boolean verify(String hostname, SSLSession session) {
            if (enabled) {
                return true;
            } else {
                return false;
            }
        }
    }
    
    public static void main(String[] args) {
        ConditionalVerifier v = new ConditionalVerifier(args.length > 0);
        // Still non-constant: depends on runtime input
    }
}