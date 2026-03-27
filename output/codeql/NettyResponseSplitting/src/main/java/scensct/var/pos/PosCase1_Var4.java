// Instantiate DefaultHttpResponse with false compile-time constant as third constructor argument should be flagged as vulnerable.
package scensct.var.pos;

import io.netty.handler.codec.http.DefaultHttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;

public class PosCase1_Var4 {
    private static boolean getValidationFlag() {
        return false; // compile-time constant return
    }
    
    public static void main(String[] args) {
        // Variant 4: Use a helper method returning false
        DefaultHttpResponse response = new DefaultHttpResponse(
            HttpVersion.HTTP_1_1,
            HttpResponseStatus.OK,
            getValidationFlag()
        );
    }
}