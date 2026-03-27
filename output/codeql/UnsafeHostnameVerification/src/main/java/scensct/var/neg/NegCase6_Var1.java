// A HostnameVerifier instance reaches a sensitive sink but the source is not a class instance creation expression should not be flagged.
package scensct.var.neg;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class NegCase6_Var1 {
    // Variant 1: Use lambda for HostnameVerifier, keep source as method return
    static class SafeVerifier {
        static HostnameVerifier create() {
            // Lambda is still a HostnameVerifier, but not a direct new expression in main
            return (hostname, session) -> 
                hostname != null && (hostname.equals("localhost") || hostname.contains(".trusted.example.com"));
        }
    }

    static HostnameVerifier obtainVerifier() {
        return SafeVerifier.create(); // Indirect via static method
    }

    public static void main(String[] args) throws Exception {
        HostnameVerifier v = obtainVerifier();
        HttpsURLConnection.setDefaultHostnameVerifier(v); // Sink
    }
}