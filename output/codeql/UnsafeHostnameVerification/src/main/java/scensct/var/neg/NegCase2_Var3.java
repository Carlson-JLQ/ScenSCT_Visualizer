// A class implements HostnameVerifier but does not define the verify method should not be flagged as insecure.
package scensct.var.neg;

import javax.net.ssl.HostnameVerifier;

public class NegCase2_Var3 {
    // Variant 3: Abstract class implementing multiple interfaces (adding a dummy)
    interface Dummy {
        void dummy();
    }
    
    abstract static class AbstractVerifier implements HostnameVerifier, Dummy {
        // No verify, and dummy is also abstract (implicitly)
        // So still no concrete implementation
    }

    public static void main(String[] args) {
        // Nothing to instantiate
    }
}