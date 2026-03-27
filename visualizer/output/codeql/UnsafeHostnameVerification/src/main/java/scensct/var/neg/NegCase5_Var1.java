// An object instantiated and flows to a sink but its type does not implement HostnameVerifier should not be flagged.
package scensct.var.neg;

import javax.net.ssl.HttpsURLConnection;

public class NegCase5_Var1 {
    static class CustomType {
        // Still not a HostnameVerifier
    }

    public static void main(String[] args) throws Exception {
        CustomType instance = new CustomType();
        // Introduce a branch that doesn't change the type
        if (args.length > 0) {
            System.out.println("Args present");
        } else {
            System.out.println("No args");
        }
        // Loop that runs once
        for (int i = 0; i < 1; i++) {
            Object target = instance; // flow to Object sink
            // Simulate a generic sink usage
            System.out.println(target.getClass());
        }
    }
}