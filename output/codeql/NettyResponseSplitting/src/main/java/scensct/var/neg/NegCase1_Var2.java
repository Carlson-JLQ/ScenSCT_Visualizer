// Instantiating a non-Netty HTTP class should not be flagged as request/response splitting vulnerability.
package scensct.var.neg;

import io.netty.handler.codec.http.DefaultHttpHeaders;

public class NegCase1_Var2 {
    // Variant 2: Extract instantiation into a helper method that returns StringBuilder.
    private static StringBuilder createBuilder() {
        return new StringBuilder();
    }

    public static void main(String[] args) {
        StringBuilder sb = createBuilder();
        sb.append("test");
        System.out.println(sb.toString());
    }
}