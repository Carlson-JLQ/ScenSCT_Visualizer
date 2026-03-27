// A class implements HostnameVerifier but does not define the verify method should not be flagged as insecure.
package scensct.var.neg;

import javax.net.ssl.HostnameVerifier;

public class NegCase2_Var5 {
    // Variant 5: Abstract class with a default method from a parent interface (Java 8+)
    interface VerifierBase extends HostnameVerifier {
        default void log(String msg) {
            System.out.println(msg);
        }
    }
    
    abstract static class AbstractVerifier implements VerifierBase {
        // No verify override, inherits default log but still abstract for verify
    }

    public static void main(String[] args) {
        // Abstract, cannot create
    }
}