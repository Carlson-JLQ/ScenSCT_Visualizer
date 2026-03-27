// Instantiate DefaultHttpRequest with false compile-time constant as fourth constructor argument should be flagged as vulnerable.
package scensct.var.pos;

import io.netty.handler.codec.http.DefaultHttpRequest;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpVersion;

public class PosCase2_Var1 {
    // Variant 1: Extract constant to a static final field
    private static final boolean VALIDATE_HEADERS = false;
    
    public static void main(String[] args) {
        DefaultHttpRequest request = new DefaultHttpRequest( // [REPORTED LINE]
            HttpVersion.HTTP_1_1,
            HttpMethod.GET,
            "/test",
            VALIDATE_HEADERS
        );
    }
}