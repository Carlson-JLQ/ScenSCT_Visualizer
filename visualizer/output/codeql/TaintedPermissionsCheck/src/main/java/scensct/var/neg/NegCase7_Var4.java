// A user-controlled value flows to an expression and the permissions construction is a WildCardPermission constructor where E is not the first argument should not be flagged.
package scensct.var.neg;

import org.apache.shiro.authz.permission.WildCardPermission;
import com.exp.AnotherClass;

public class NegCase7_Var4 {
    public static void main(String[] args) {
        // Variant 4: Control‑flow restructuring with branching, but tainted still not first.
        AnotherClass obj = new AnotherClass();
        String data = obj.toString();
        String firstPart = "predefined";
        String secondPart = data;
        String combined;
        if (firstPart.length() > 0) {
            combined = firstPart + "|" + secondPart;
        } else {
            combined = secondPart; // This branch never taken, but preserves scenario.
        }
        // In the taken branch, data is second part.
        WildCardPermission perm = new WildCardPermission(combined);
    }
}