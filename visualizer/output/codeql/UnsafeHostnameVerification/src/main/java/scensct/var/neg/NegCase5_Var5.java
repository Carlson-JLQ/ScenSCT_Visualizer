// An object instantiated and flows to a sink but its type does not implement HostnameVerifier should not be flagged.
package scensct.var.neg;

import javax.net.ssl.HttpsURLConnection;

public class NegCase5_Var5 {
    static class OtherVerifier {
        // Not javax.net.ssl.HostnameVerifier
    }

    public static void main(String[] args) throws Exception {
        final OtherVerifier ov;
        try {
            ov = new OtherVerifier();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Object sink = ov;
        // Sink call
        System.out.println(sink.getClass().getName());
    }
}