// Instantiate CombinedHttpHeaders with false compile-time constant as first constructor argument should be flagged as vulnerable.
package scensct.core.pos;

import io.netty.handler.codec.http.CombinedHttpHeaders;

public class PosCase5 {
    public static void main(String[] args) {
        // Scenario 5: validate set to false compile-time constant
        CombinedHttpHeaders headers = new CombinedHttpHeaders(false);  // First argument: validate // [REPORTED LINE]
    }
}