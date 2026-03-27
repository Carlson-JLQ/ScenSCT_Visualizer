// Instantiate DefaultHttpRequest with false compile-time constant as fourth constructor argument should be flagged as vulnerable.
package scensct.core.pos;

import io.netty.handler.codec.http.DefaultHttpRequest;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpVersion;

public class PosCase2 {
    public static void main(String[] args) {
        // Scenario 2: validateHeaders set to false compile-time constant
        DefaultHttpRequest request = new DefaultHttpRequest( // [REPORTED LINE]
            HttpVersion.HTTP_1_1,
            HttpMethod.GET,
            "/test",
            false  // Fourth argument: validateHeaders
        );
    }
}