// Instantiating a non-Netty HTTP class should not be flagged as request/response splitting vulnerability.
package scensct.var.neg;

import io.netty.handler.codec.http.DefaultHttpHeaders;

public class NegCase1_Var3 {
    // Variant 3: Use a factory pattern with an interface, but still produce StringBuilder.
    interface BuilderFactory {
        StringBuilder create();
    }

    public static void main(String[] args) {
        BuilderFactory factory = new BuilderFactory() {
            @Override
            public StringBuilder create() {
                return new StringBuilder();
            }
        };
        StringBuilder sb = factory.create();
        sb.append("test");
        System.out.println(sb.toString());
    }
}