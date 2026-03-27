// Instantiate DefaultHttpResponse with false compile-time constant as third constructor argument should be flagged as vulnerable.
package scensct.var.pos;

import io.netty.handler.codec.http.DefaultHttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;

public class PosCase1_Var2 {
    private static final boolean VALIDATE_HEADERS = false;
    
    public static void main(String[] args) {
        // Variant 2: Use a static final field (compile-time constant)
        DefaultHttpResponse response = new DefaultHttpResponse( // [REPORTED LINE]
            HttpVersion.HTTP_1_1,
            HttpResponseStatus.OK,
            VALIDATE_HEADERS
        );
    }
}