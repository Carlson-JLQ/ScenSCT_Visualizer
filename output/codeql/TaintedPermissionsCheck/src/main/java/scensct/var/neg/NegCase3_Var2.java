// A permissions check uses an expression with no taint flow from a user-controlled source should not be flagged.
package scensct.var.neg;

import org.apache.shiro.authz.permission.WildCardPermission;
import com.exp.AnotherClass;

public class NegCase3_Var2 {
    // Variant 2: Extract permission construction to a helper method, passing safe literal.
    public static void main(String[] args) {
        AnotherClass userInput = new AnotherClass(); // Source
        createPermission("static:permission"); // Safe argument passed
    }
    
    private static void createPermission(String permStr) {
        WildCardPermission perm = new WildCardPermission(permStr); // Sink inside helper
    }
}