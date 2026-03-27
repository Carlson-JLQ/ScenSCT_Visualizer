// Instantiate CombinedHttpHeaders with false compile-time constant as first constructor argument should be flagged as vulnerable.
package scensct.var.pos;

import io.netty.handler.codec.http.CombinedHttpHeaders;

public class PosCase5_Var3 {
    private static boolean getValidationFlag() {
        return false;
    }
    
    public static void main(String[] args) {
        CombinedHttpHeaders headers = new CombinedHttpHeaders(getValidationFlag());
    }
}