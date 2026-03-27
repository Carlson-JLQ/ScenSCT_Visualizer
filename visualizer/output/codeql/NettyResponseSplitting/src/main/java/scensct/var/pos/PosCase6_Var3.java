// Instantiate DefaultHttpHeaders with false compile-time constant as first constructor argument should be flagged as vulnerable.
package scensct.var.pos;

import io.netty.handler.codec.http.DefaultHttpHeaders;

public class PosCase6_Var3 {
    public static void main(String[] args) {
        // Variant 3: Use a conditional that always evaluates to false
        boolean flag = args.length > 1000; // Always false at runtime
        DefaultHttpHeaders headers = new DefaultHttpHeaders(flag);
    }
}