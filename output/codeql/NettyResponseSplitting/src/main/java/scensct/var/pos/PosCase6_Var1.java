// Instantiate DefaultHttpHeaders with false compile-time constant as first constructor argument should be flagged as vulnerable.
package scensct.var.pos;

import io.netty.handler.codec.http.DefaultHttpHeaders;

public class PosCase6_Var1 {
    public static void main(String[] args) {
        // Variant 1: Use a final local variable for the constant
        final boolean skipValidation = false;
        DefaultHttpHeaders headers = new DefaultHttpHeaders(skipValidation); // [REPORTED LINE]
    }
}