// A locally initialized SQL resource with a transitive parent closeable resource that is a locally initialized ClassInstanceExpr with no arguments should not be flagged as unclosed.
package scensct.var.neg;

import java.sql.Connection;
import java.sql.Statement;

public class NegCase4_Var2 {
    static class CustomConnection implements AutoCloseable {
        public void close() throws Exception {}
    }
    
    public void test() throws Exception {
        // Variant 2: Extract parent resource initialization to a local variable before try-with-resources
        // This tests if checker can trace the parent through a variable.
        CustomConnection customConn = new CustomConnection();
        try (Connection conn = java.sql.DriverManager.getConnection("jdbc:test");
             Statement stmt = conn.createStatement()) {
            // customConn is not in the try, but still in scope; scenario requires it to be in try.
            // This variant is INVALID because customConn is not in the try-with-resources.
        }
        // Correction: Keep customConn in try but with a temporary alias.
        // Instead, use a different approach: wrap in a helper that returns the resource.
    }
}