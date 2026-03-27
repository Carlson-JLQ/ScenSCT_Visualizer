// Instantiate DefaultHttpRequest with false compile-time constant as fourth constructor argument should be flagged as vulnerable.
package scensct.var.pos;

import io.netty.handler.codec.http.DefaultHttpRequest;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpVersion;

public class PosCase2_Var4 {
    // Variant 4: Introduce intermediate variables for all parameters
    public static void main(String[] args) {
        HttpVersion version = HttpVersion.HTTP_1_1;
        HttpMethod method = HttpMethod.GET;
        String path = "/test";
        boolean validate = false;
        
        DefaultHttpRequest request = new DefaultHttpRequest( // [REPORTED LINE]
            version,
            method,
            path,
            validate
        );
    }
}