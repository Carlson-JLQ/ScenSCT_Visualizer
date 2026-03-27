// A HostnameVerifier's verify method returns a non-constant boolean expression should not be flagged as always true.
package scensct.var.neg;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class NegCase3_Var3 {
    // Variant 3: Use an anonymous class implementing HostnameVerifier
    public static void main(String[] args) {
        final boolean flag = args.length == 0;
        HostnameVerifier verifier = new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return flag; // Captured variable, non-constant
            }
        };
        // Still negative: depends on runtime argument
    }
}