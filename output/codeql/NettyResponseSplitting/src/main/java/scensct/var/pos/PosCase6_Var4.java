// Instantiate DefaultHttpHeaders with false compile-time constant as first constructor argument should be flagged as vulnerable.
package scensct.var.pos;

import io.netty.handler.codec.http.DefaultHttpHeaders;

public class PosCase6_Var4 {
    public static void main(String[] args) {
        // Variant 4: Wrap in try-catch without affecting the call
        try {
            DefaultHttpHeaders headers = new DefaultHttpHeaders(false); // [REPORTED LINE]
        } catch (Exception e) {
            // Ignore
        }
    }
}