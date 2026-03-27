// Instantiate DefaultHttpResponse with false compile-time constant as third constructor argument should be flagged as vulnerable.
package scensct.var.pos;

import io.netty.handler.codec.http.DefaultHttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;

public class PosCase1_Var5 {
    private static void createResponse() {
        // Variant 5: Move instantiation to a separate method, still with constant false
        DefaultHttpResponse response = new DefaultHttpResponse( // [REPORTED LINE]
            HttpVersion.HTTP_1_1,
            HttpResponseStatus.OK,
            false
        );
    }
    
    public static void main(String[] args) {
        createResponse();
    }
}