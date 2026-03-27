// Instantiate DefaultHttpResponse with false compile-time constant as third constructor argument should be flagged as vulnerable.
package scensct.core.pos;

import io.netty.handler.codec.http.DefaultHttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;

public class PosCase1 {
    public static void main(String[] args) {
        // Scenario 1: validateHeaders set to false compile-time constant
        DefaultHttpResponse response = new DefaultHttpResponse( // [REPORTED LINE]
            HttpVersion.HTTP_1_1,
            HttpResponseStatus.OK,
            false  // Third argument: validateHeaders
        );
    }
}