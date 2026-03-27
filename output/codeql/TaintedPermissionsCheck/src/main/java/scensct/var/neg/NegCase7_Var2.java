// A user-controlled value flows to an expression and the permissions construction is a WildCardPermission constructor where E is not the first argument should not be flagged.
package scensct.var.neg;

import org.apache.shiro.authz.permission.WildCardPermission;
import com.exp.AnotherClass;

public class NegCase7_Var2 {
    public static void main(String[] args) {
        // Variant 2: Tainted value flows through a temporary array, then concatenated.
        AnotherClass input = new AnotherClass();
        String t = input.toString();
        String[] parts = {"safe", t, "other"};
        String constructed = String.join(":", parts); // t is second element, not first.
        WildCardPermission perm = new WildCardPermission(constructed);
    }
}