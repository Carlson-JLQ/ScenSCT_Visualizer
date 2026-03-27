// Instantiate CombinedHttpHeaders with false compile-time constant as first constructor argument should be flagged as vulnerable.
package scensct.var.pos;

import io.netty.handler.codec.http.CombinedHttpHeaders;

public class PosCase5_Var4 {
    public static void main(String[] args) {
        final boolean validateFlag = false;
        CombinedHttpHeaders headers = null;
        headers = new CombinedHttpHeaders(validateFlag); // [REPORTED LINE]
    }
}