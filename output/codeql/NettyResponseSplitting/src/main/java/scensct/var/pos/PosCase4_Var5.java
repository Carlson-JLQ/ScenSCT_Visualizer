// Instantiate DefaultFullHttpRequest with false compile-time constant as fourth constructor argument should be flagged as vulnerable.
package scensct.var.pos;

import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.buffer.Unpooled;

public class PosCase4_Var5 {
    public static void main(String[] args) {
        // Variant 5: Inline the call with a temporary variable for the buffer
        var buffer = Unpooled.buffer(0);
        var method = HttpMethod.GET;
        var version = HttpVersion.HTTP_1_1;
        DefaultFullHttpRequest request = new DefaultFullHttpRequest( // [REPORTED LINE]
            version,
            method,
            "/test",
            buffer,
            false
        );
    }
}