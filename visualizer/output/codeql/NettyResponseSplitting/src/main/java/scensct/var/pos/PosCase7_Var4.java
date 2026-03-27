// Instantiate DefaultFullHttpResponse with false compile-time constant as fourth constructor argument should be flagged as vulnerable.
package scensct.var.pos;

import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.buffer.Unpooled;

public class PosCase7_Var4 {
    public static void main(String[] args) {
        // Variant 4: Wrap in a try-finally block (no effect on constant)
        try {
            DefaultFullHttpResponse response = new DefaultFullHttpResponse( // [REPORTED LINE]
                HttpVersion.HTTP_1_1,
                HttpResponseStatus.OK,
                Unpooled.buffer(0),
                false,
                false
            );
        } finally {
            System.out.println("Done");
        }
    }
}