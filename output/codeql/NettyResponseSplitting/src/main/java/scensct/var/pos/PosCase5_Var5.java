// Instantiate CombinedHttpHeaders with false compile-time constant as first constructor argument should be flagged as vulnerable.
package scensct.var.pos;

import io.netty.handler.codec.http.CombinedHttpHeaders;

public class PosCase5_Var5 {
    public static void main(String[] args) {
        // Using a constant expression that evaluates to false
        CombinedHttpHeaders headers = new CombinedHttpHeaders(1 > 2); // [REPORTED LINE]
    }
}