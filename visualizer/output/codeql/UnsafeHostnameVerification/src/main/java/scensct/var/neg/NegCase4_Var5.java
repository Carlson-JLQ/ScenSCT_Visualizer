// A HostnameVerifier's verify method returns constant false should not be flagged as always true.
package scensct.var.neg;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class NegCase4_Var5 {
    // Variant 5: try-catch-finally that returns false in all paths
    static class AlwaysFalseVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            try {
                // Some operation that doesn't throw
                int x = hostname.length();
                return false;
            } catch (Exception e) {
                return false;
            } finally {
                // finally runs after return, but doesn't change return value
            }
        }
    }

    public static void main(String[] args) {
        AlwaysFalseVerifier verifier = new AlwaysFalseVerifier();
    }
}