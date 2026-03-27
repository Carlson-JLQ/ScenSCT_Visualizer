// Instantiate DefaultHttpRequest with false compile-time constant as fourth constructor argument should be flagged as vulnerable.
package scensct.var.pos;

import io.netty.handler.codec.http.DefaultHttpRequest;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpVersion;

public class PosCase2_Var2 {
    // Variant 2: Use a helper method that returns the constant false
    public static void main(String[] args) {
        DefaultHttpRequest request = createRequest("/test");
    }
    
    private static DefaultHttpRequest createRequest(String path) {
        return new DefaultHttpRequest(
            HttpVersion.HTTP_1_1,
            HttpMethod.GET,
            path,
            getValidationFlag()
        );
    }
    
    private static boolean getValidationFlag() {
        return false;
    }
}