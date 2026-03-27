// An object instantiated and flows to a sink but its type does not implement HostnameVerifier should not be flagged.
package scensct.core.neg;

import javax.net.ssl.HttpsURLConnection;

public class NegCase5 {
    static class OtherType {
        // Not a HostnameVerifier
    }

    public static void main(String[] args) throws Exception {
        OtherType obj = new OtherType();
        // Cast to Object to simulate flow to a sink that expects Object, not HostnameVerifier
        Object sinkParam = obj;
        // Hypothetical sink that accepts Object; no HostnameVerifier involved
        // This should not trigger the checker
    }
}