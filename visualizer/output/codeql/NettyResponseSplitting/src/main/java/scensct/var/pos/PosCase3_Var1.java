// Instantiate DefaultFullHttpResponse with false compile-time constant as third constructor argument should be flagged as vulnerable.
package scensct.var.pos;

import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.buffer.Unpooled;

public class PosCase3_Var1 {
    // Variant 1: Extract false as a final local variable
    public static void main(String[] args) {
        final boolean skipValidation = false;
        DefaultFullHttpResponse response = new DefaultFullHttpResponse( // [REPORTED LINE]
            HttpVersion.HTTP_1_1,
            HttpResponseStatus.OK,
            Unpooled.buffer(0),
            skipValidation
        );
    }
}