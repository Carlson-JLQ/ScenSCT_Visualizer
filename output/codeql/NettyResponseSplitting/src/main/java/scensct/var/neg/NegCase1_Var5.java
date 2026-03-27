// Instantiating a non-Netty HTTP class should not be flagged as request/response splitting vulnerability.
package scensct.var.neg;

import io.netty.handler.codec.http.DefaultHttpHeaders;

public class NegCase1_Var5 {
    public static void main(String[] args) {
        // Variant 5: Use a different standard Java class (StringBuffer) instead of StringBuilder,
        // but still not a Netty HTTP class.
        StringBuffer sb = new StringBuffer();
        sb.append("test");
        System.out.println(sb.toString());
    }
}