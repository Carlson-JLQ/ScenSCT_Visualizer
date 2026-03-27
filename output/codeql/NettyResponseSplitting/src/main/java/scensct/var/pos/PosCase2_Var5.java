// Instantiate DefaultHttpRequest with false compile-time constant as fourth constructor argument should be flagged as vulnerable.
package scensct.var.pos;

import io.netty.handler.codec.http.DefaultHttpRequest;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpVersion;

public class PosCase2_Var5 {
    // Variant 5: Wrap in a try-catch block (preserves reachability)
    public static void main(String[] args) {
        try {
            DefaultHttpRequest request = new DefaultHttpRequest( // [REPORTED LINE]
                HttpVersion.HTTP_1_1,
                HttpMethod.GET,
                "/test",
                false
            );
        } catch (Exception e) {
            // Ignore
        }
    }
}