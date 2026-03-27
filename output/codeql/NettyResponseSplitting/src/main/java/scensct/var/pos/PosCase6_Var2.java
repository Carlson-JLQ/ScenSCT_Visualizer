// Instantiate DefaultHttpHeaders with false compile-time constant as first constructor argument should be flagged as vulnerable.
package scensct.var.pos;

import io.netty.handler.codec.http.DefaultHttpHeaders;

public class PosCase6_Var2 {
    public static void main(String[] args) {
        // Variant 2: Extract instantiation to a helper method
        DefaultHttpHeaders headers = createHeaders(false);
    }
    
    private static DefaultHttpHeaders createHeaders(boolean validate) {
        return new DefaultHttpHeaders(validate);
    }
}