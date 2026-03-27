// An object instantiated and flows to a sink but its type does not implement HostnameVerifier should not be flagged.
package scensct.var.neg;

import javax.net.ssl.HttpsURLConnection;

public class NegCase5_Var3 {
    static class NonHostnameVerifier {
        // Not implementing HostnameVerifier
    }

    public static void main(String[] args) throws Exception {
        NonHostnameVerifier a = new NonHostnameVerifier();
        Object b = (Object) a; // explicit upcast
        NonHostnameVerifier c = (NonHostnameVerifier) b; // downcast
        Object d = c; // upcast again
        // Final sink
        System.out.println(d.hashCode());
    }
}