// Instantiate DefaultFullHttpResponse with false compile-time constant as third constructor argument should be flagged as vulnerable.
package scensct.var.pos;

import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.buffer.Unpooled;

public class PosCase3_Var5 {
    // Variant 5: Inline everything, but swap argument order using temporary variables
    public static void main(String[] args) {
        HttpVersion ver = HttpVersion.HTTP_1_1;
        HttpResponseStatus status = HttpResponseStatus.OK;
        boolean validate = false;
        DefaultFullHttpResponse response = new DefaultFullHttpResponse( // [REPORTED LINE]
            ver,
            status,
            Unpooled.buffer(0),
            validate
        );
    }
}