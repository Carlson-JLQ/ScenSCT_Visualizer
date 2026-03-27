// Instantiating a non-Netty HTTP class should not be flagged as request/response splitting vulnerability.
package scensct.core.neg;

import io.netty.handler.codec.http.DefaultHttpHeaders;

public class NegCase1 {
    public static void main(String[] args) {
        // Scenario 1: Instantiate a class not among the six specified Netty HTTP classes.
        // Using a standard Java class (StringBuilder) which is unrelated to Netty HTTP headers.
        StringBuilder sb = new StringBuilder();
        sb.append("test");
        System.out.println(sb.toString());
    }
}