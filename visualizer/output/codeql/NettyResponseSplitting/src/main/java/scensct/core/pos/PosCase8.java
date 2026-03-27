// Instantiate DefaultFullHttpRequest with false compile-time constant as fifth constructor argument should be flagged as vulnerable.
package scensct.core.pos;

import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.buffer.Unpooled;

public class PosCase8 {
    public static void main(String[] args) {
        // Scenario 8: validateHeaders set to false compile-time constant (fifth argument)
        DefaultFullHttpRequest request = new DefaultFullHttpRequest(
            HttpVersion.HTTP_1_1,
            HttpMethod.GET,
            "/test",
            Unpooled.buffer(0),
            true,   // Fourth argument: validateHeaders (true, not relevant)
            false   // Fifth argument: validateHeaders (false, triggers scenario)
        );
    }
}