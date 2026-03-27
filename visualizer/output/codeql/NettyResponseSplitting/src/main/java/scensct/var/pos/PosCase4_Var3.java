// Instantiate DefaultFullHttpRequest with false compile-time constant as fourth constructor argument should be flagged as vulnerable.
package scensct.var.pos;

import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.buffer.Unpooled;

public class PosCase4_Var3 {
    private static boolean getValidationFlag() {
        return false;
    }
    
    public static void main(String[] args) {
        // Variant 3: Use a helper method that returns false (compile-time constant)
        DefaultFullHttpRequest request = new DefaultFullHttpRequest(
            HttpVersion.HTTP_1_1,
            HttpMethod.GET,
            "/test",
            Unpooled.buffer(0),
            getValidationFlag()
        );
    }
}