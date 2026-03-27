// A HostnameVerifier that always returns true but is never used in a hostname verification sink should not be flagged as insecure.
package scensct.var.neg;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class NegCase1_Var5 {
    // Variant 5: Try-catch with verifier creation, aliasing
    public static void main(String[] args) {
        try {
            HostnameVerifier v1 = (h, s) -> true;
            HostnameVerifier v2 = v1; // alias
            // Still no sink
            if (v2 != null) {
                // empty block, no sink
            }
        } catch (Exception e) {
            // ignore
        }
    }
}