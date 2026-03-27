// Instantiating a non-Netty HTTP class should not be flagged as request/response splitting vulnerability.
package scensct.var.neg;

import io.netty.handler.codec.http.DefaultHttpHeaders;

public class NegCase1_Var1 {
    public static void main(String[] args) {
        // Variant 1: Introduce a temporary variable and a conditional that doesn't affect instantiation.
        Object obj;
        if (args.length > 0) {
            obj = new StringBuilder();
        } else {
            obj = new StringBuilder();
        }
        StringBuilder sb = (StringBuilder) obj;
        sb.append("test");
        System.out.println(sb.toString());
    }
}