// A locally initialized SQL resource with a transitive parent closeable resource associated with a local variable should not be flagged as unclosed.
package scensct.var.neg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class NegCase3_Var1 {
    public void test() throws Exception {
        // Reorder resources, rename, but same transitive closure
        try (Statement s = DriverManager.getConnection("jdbc:test").createStatement();
             Connection c = DriverManager.getConnection("jdbc:test")) {
            // s is still closed via its parent connection? Wait, this breaks the invariant.
            // Correction: s must be derived from c.
        }
    }
}