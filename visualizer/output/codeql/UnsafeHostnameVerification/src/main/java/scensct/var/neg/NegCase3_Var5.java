// A HostnameVerifier's verify method returns a non-constant boolean expression should not be flagged as always true.
package scensct.var.neg;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class NegCase3_Var5 {
    // Variant 5: Use a lambda expression (Java 8+), still non-constant
    public static void main(String[] args) {
        boolean decision = Boolean.parseBoolean(System.getProperty("accept", "false"));
        HostnameVerifier verifier = (hostname, session) -> decision;
        // Depends on system property, not constant true
    }
}