// A class implements HostnameVerifier but does not define the verify method should not be flagged as insecure.
package scensct.var.neg;

import javax.net.ssl.HostnameVerifier;

public class NegCase2_Var2 {
    // Variant 2: Abstract class with static nested abstract class
    private abstract static class BaseVerifier implements HostnameVerifier {
        // No verify defined here
    }
    
    abstract static class AbstractVerifier extends BaseVerifier {
        // Still abstract, no verify
    }

    public static void main(String[] args) {
        // Abstract chain
    }
}