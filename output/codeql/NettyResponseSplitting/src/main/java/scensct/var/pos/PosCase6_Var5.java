// Instantiate DefaultHttpHeaders with false compile-time constant as first constructor argument should be flagged as vulnerable.
package scensct.var.pos;

import io.netty.handler.codec.http.DefaultHttpHeaders;

public class PosCase6_Var5 {
    // Variant 5: Use a static final field
    private static final boolean VALIDATE = false;
    
    public static void main(String[] args) {
        DefaultHttpHeaders headers = new DefaultHttpHeaders(VALIDATE); // [REPORTED LINE]
    }
}