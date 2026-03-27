// Instantiate DefaultHttpResponse with false compile-time constant as third constructor argument should be flagged as vulnerable.
package scensct.var.pos;

import io.netty.handler.codec.http.DefaultHttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;

public class PosCase1_Var3 {
    public static void main(String[] args) {
        // Variant 3: Introduce a local variable initialized to false
        boolean shouldValidate = false;
        DefaultHttpResponse response = new DefaultHttpResponse( // [REPORTED LINE]
            HttpVersion.HTTP_1_1,
            HttpResponseStatus.OK,
            shouldValidate
        );
    }
}