// Instantiate CombinedHttpHeaders with false compile-time constant as first constructor argument should be flagged as vulnerable.
package scensct.var.pos;

import io.netty.handler.codec.http.CombinedHttpHeaders;

public class PosCase5_Var1 {
    private static final boolean VALIDATE = false;
    
    public static void main(String[] args) {
        CombinedHttpHeaders headers = new CombinedHttpHeaders(VALIDATE); // [REPORTED LINE]
    }
}