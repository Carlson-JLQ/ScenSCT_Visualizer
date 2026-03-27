// Instantiate DefaultHttpHeaders with false compile-time constant as first constructor argument should be flagged as vulnerable.
package scensct.core.pos;

import io.netty.handler.codec.http.DefaultHttpHeaders;

public class PosCase6 {
    public static void main(String[] args) {
        // Scenario 6: validate set to false compile-time constant
        DefaultHttpHeaders headers = new DefaultHttpHeaders(false);  // First argument: validate // [REPORTED LINE]
    }
}