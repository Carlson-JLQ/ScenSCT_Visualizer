// A class implements HostnameVerifier but does not define the verify method should not be flagged as insecure.
package scensct.var.neg;

import javax.net.ssl.HostnameVerifier;

public class NegCase2_Var4 {
    // Variant 4: Abstract class with static initializer and fields
    abstract static class AbstractVerifier implements HostnameVerifier {
        static final String TAG = "HostnameVerifier";
        static {
            System.out.println(TAG + " class loaded");
        }
        // No verify method
    }

    public static void main(String[] args) {
        // Class loading might occur, but no instance
    }
}