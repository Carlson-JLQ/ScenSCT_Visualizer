// Instantiate DefaultFullHttpRequest with false compile-time constant as fourth constructor argument should be flagged as vulnerable.
package scensct.var.pos;

import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.buffer.Unpooled;

public class PosCase4_Var2 {
    public static void main(String[] args) {
        // Variant 2: Use Boolean.FALSE (auto-unboxed to false)
        boolean validateHeaders = Boolean.FALSE;
        DefaultFullHttpRequest request = new DefaultFullHttpRequest(
            HttpVersion.HTTP_1_1,
            HttpMethod.GET,
            "/test",
            Unpooled.buffer(0),
            validateHeaders
        );
    }
}