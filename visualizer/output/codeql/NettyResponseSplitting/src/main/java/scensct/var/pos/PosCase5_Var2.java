// Instantiate CombinedHttpHeaders with false compile-time constant as first constructor argument should be flagged as vulnerable.
package scensct.var.pos;

import io.netty.handler.codec.http.CombinedHttpHeaders;

public class PosCase5_Var2 {
    public static void main(String[] args) {
        boolean shouldValidate = false;
        CombinedHttpHeaders headers = new CombinedHttpHeaders(shouldValidate); // [REPORTED LINE]
    }
}