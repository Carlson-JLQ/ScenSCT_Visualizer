// A class implements HostnameVerifier but does not define the verify method should not be flagged as insecure.
package scensct.core.neg;

import javax.net.ssl.HostnameVerifier;

public class NegCase2 {
    // Abstract class implementing HostnameVerifier without defining verify
    abstract static class AbstractVerifier implements HostnameVerifier {
        // No verify method implementation; abstract or missing
        // This does not always return true, so no violation
    }

    public static void main(String[] args) {
        // Cannot instantiate abstract class, but scenario focuses on definition
    }
}