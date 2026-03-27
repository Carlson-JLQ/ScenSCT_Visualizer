// Instantiate DefaultFullHttpResponse with false compile-time constant as third constructor argument should be flagged as vulnerable.
package scensct.core.pos;

import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.buffer.Unpooled;

public class PosCase3 {
    public static void main(String[] args) {
        // Scenario 3: validateHeaders set to false compile-time constant
        DefaultFullHttpResponse response = new DefaultFullHttpResponse( // [REPORTED LINE]
            HttpVersion.HTTP_1_1,
            HttpResponseStatus.OK,
            Unpooled.buffer(0),
            false  // Third argument: validateHeaders
        );
    }
}