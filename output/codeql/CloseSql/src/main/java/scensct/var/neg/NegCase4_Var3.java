// A locally initialized SQL resource with a transitive parent closeable resource that is a locally initialized ClassInstanceExpr with no arguments should not be flagged as unclosed.
package scensct.var.neg;

import java.sql.Connection;
import java.sql.Statement;

public class NegCase4_Var3 {
    static class CustomConnection implements AutoCloseable {
        public void close() throws Exception {}
    }
    
    private CustomConnection makeCustomConnection() {
        return new CustomConnection();
    }
    
    public void test() throws Exception {
        // Variant 2: Parent resource created via a helper method, still no-arg ClassInstanceExpr.
        // This tests if checker can see through simple method calls.
        try (CustomConnection customConn = makeCustomConnection();
             Connection conn = java.sql.DriverManager.getConnection("jdbc:test");
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("DELETE FROM test");
        }
    }
}