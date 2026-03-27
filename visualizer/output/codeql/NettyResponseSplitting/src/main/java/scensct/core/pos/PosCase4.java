// Instantiate DefaultFullHttpRequest with false compile-time constant as fourth constructor argument should be flagged as vulnerable.
package scensct.core.pos;

import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.buffer.Unpooled;

public class PosCase4 {
    public static void main(String[] args) {
        // Scenario 4: validateHeaders set to false compile-time constant
        DefaultFullHttpRequest request = new DefaultFullHttpRequest( // [REPORTED LINE]
            HttpVersion.HTTP_1_1,
            HttpMethod.GET,
            "/test",
            Unpooled.buffer(0),
            false  // Fourth argument: validateHeaders
        );
    }
}