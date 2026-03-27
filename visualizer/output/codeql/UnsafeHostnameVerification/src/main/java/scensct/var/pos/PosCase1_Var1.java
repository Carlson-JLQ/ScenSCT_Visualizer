// A HostnameVerifier that always returns true is set as default without any guard should be flagged as unsafe.
package scensct.var.pos;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class PosCase1_Var1 {
    // Variant 1: Lambda expression for verifier, with intermediate variable
    public static void main(String[] args) {
        HostnameVerifier alwaysAccept = (String host, SSLSession sess) -> true;
        HttpsURLConnection.setDefaultHostnameVerifier(alwaysAccept); // [REPORTED LINE]
    }
}