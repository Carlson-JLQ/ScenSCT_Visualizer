// Instantiating a non-Netty HTTP class should not be flagged as request/response splitting vulnerability.
package scensct.var.neg;

import io.netty.handler.codec.http.DefaultHttpHeaders;

public class NegCase1_Var4 {
    public static void main(String[] args) {
        // Variant 4: Wrap instantiation in a try-catch block, but keep it as StringBuilder.
        StringBuilder sb = null;
        try {
            sb = new StringBuilder();
        } catch (Exception e) {
            sb = new StringBuilder();
        }
        sb.append("test");
        System.out.println(sb.toString());
    }
}