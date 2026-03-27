// Instantiate DefaultFullHttpResponse with false compile-time constant as third constructor argument should be flagged as vulnerable.
package scensct.var.pos;

import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.buffer.Unpooled;

public class PosCase3_Var2 {
    // Variant 2: Use a static final field for false, instantiate in a try-catch
    private static final boolean VALIDATE_HEADERS = false;
    
    public static void main(String[] args) {
        try {
            DefaultFullHttpResponse response = new DefaultFullHttpResponse( // [REPORTED LINE]
                HttpVersion.HTTP_1_1,
                HttpResponseStatus.OK,
                Unpooled.buffer(0),
                VALIDATE_HEADERS
            );
        } catch (Exception e) {
            // Ignore, just for control flow variation
        }
    }
}