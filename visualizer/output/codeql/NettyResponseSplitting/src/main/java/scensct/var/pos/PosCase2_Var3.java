// Instantiate DefaultHttpRequest with false compile-time constant as fourth constructor argument should be flagged as vulnerable.
package scensct.var.pos;

import io.netty.handler.codec.http.DefaultHttpRequest;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpVersion;

public class PosCase2_Var3 {
    // Variant 3: Use a ternary operator with compile-time constant condition
    public static void main(String[] args) {
        final boolean flag = (1 > 2) ? true : false;
        DefaultHttpRequest request = new DefaultHttpRequest( // [REPORTED LINE]
            HttpVersion.HTTP_1_1,
            HttpMethod.GET,
            "/test",
            flag
        );
    }
}