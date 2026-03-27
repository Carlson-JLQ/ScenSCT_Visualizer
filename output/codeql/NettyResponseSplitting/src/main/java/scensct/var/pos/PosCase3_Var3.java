// Instantiate DefaultFullHttpResponse with false compile-time constant as third constructor argument should be flagged as vulnerable.
package scensct.var.pos;

import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.buffer.Unpooled;

public class PosCase3_Var3 {
    // Variant 3: Extract instantiation to a helper method that returns the response
    public static void main(String[] args) {
        DefaultFullHttpResponse resp = createResponse(false);
    }
    
    private static DefaultFullHttpResponse createResponse(boolean validate) {
        // validate is a compile-time constant false due to inline argument
        return new DefaultFullHttpResponse(
            HttpVersion.HTTP_1_1,
            HttpResponseStatus.OK,
            Unpooled.buffer(0),
            validate
        );
    }
}