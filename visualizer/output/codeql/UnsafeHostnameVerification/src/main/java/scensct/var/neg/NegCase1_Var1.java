// A HostnameVerifier that always returns true but is never used in a hostname verification sink should not be flagged as insecure.
package scensct.var.neg;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class NegCase1_Var1 {
    // Variant 1: Lambda expression and unused assignment
    public static void main(String[] args) {
        HostnameVerifier verifier = (hostname, session) -> true;
        // Still no sink usage, just stored in a variable
        if (args.length > 1000) { // dead code
            // Not a sink, just a dummy call
            verifier.verify("example.com", null);
        }
    }
}