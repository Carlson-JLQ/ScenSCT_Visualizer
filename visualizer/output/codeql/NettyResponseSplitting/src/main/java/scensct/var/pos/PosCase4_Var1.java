// Instantiate DefaultFullHttpRequest with false compile-time constant as fourth constructor argument should be flagged as vulnerable.
package scensct.var.pos;

import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.buffer.Unpooled;

public class PosCase4_Var1 {
    private static final boolean NO_VALIDATION = false;
    
    public static void main(String[] args) {
        // Variant 1: Use a static final constant
        DefaultFullHttpRequest request = new DefaultFullHttpRequest( // [REPORTED LINE]
            HttpVersion.HTTP_1_1,
            HttpMethod.GET,
            "/test",
            Unpooled.buffer(0),
            NO_VALIDATION
        );
    }
}