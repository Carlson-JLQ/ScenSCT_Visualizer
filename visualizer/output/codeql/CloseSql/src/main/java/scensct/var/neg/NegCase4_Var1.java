// A locally initialized SQL resource with a transitive parent closeable resource that is a locally initialized ClassInstanceExpr with no arguments should not be flagged as unclosed.
package scensct.var.neg;

import java.sql.Connection;
import java.sql.Statement;

public class NegCase4_Var1 {
    static class CustomConnection implements AutoCloseable {
        public void close() throws Exception {}
    }
    
    public void test() throws Exception {
        // Variant 1: Reorder resources, but keep CustomConnection as first parent
        // This tests if checker relies on order for transitive safety.
        try (Connection conn = java.sql.DriverManager.getConnection("jdbc:test");
             CustomConnection customConn = new CustomConnection();
             Statement stmt = conn.createStatement()) {
            // Use resources
            stmt.execute("SELECT 1");
        }
    }
}