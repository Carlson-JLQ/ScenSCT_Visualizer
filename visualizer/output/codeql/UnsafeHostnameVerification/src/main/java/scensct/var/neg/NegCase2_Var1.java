// A class implements HostnameVerifier but does not define the verify method should not be flagged as insecure.
package scensct.var.neg;

import javax.net.ssl.HostnameVerifier;

public class NegCase2_Var1 {
    // Variant 1: Abstract class with additional abstract method and generic type
    abstract static class AbstractHostnameVerifier<T> implements HostnameVerifier {
        // Still no verify implementation
        abstract T getConfig();
    }

    public static void main(String[] args) {
        // No instantiation possible
    }
}