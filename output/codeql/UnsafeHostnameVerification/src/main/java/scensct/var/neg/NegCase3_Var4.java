// A HostnameVerifier's verify method returns a non-constant boolean expression should not be flagged as always true.
package scensct.var.neg;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class NegCase3_Var4 {
    // Variant 4: Add an irrelevant static field and use instance field via ternary
    static class ConditionalVerifier implements HostnameVerifier {
        private boolean flag;
        private static int counter = 0;
        
        public ConditionalVerifier(boolean flag) {
            this.flag = flag;
            counter++;
        }
        
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return flag ? true : false; // Still depends on instance field
        }
    }
    
    public static void main(String[] args) {
        ConditionalVerifier v1 = new ConditionalVerifier(true);
        ConditionalVerifier v2 = new ConditionalVerifier(false);
        // Different instances have different behaviors
    }
}