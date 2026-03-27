// A locally initialized SQL resource with a transitive parent closeable resource that is a locally initialized ClassInstanceExpr with no arguments should not be flagged as unclosed.
package scensct.var.neg;

import java.sql.Connection;
import java.sql.Statement;

public class NegCase4_Var6 {
    static class CustomConnection implements AutoCloseable {
        public void close() throws Exception {}
    }
    
    public void test() throws Exception {
        // Variant 5: Use multiple parent resources of same type, all no-arg ClassInstanceExpr.
        // This tests if checker handles multiple safe parents.
        try (CustomConnection customConn1 = new CustomConnection();
             CustomConnection customConn2 = new CustomConnection();
             Connection conn = java.sql.DriverManager.getConnection("jdbc:test");
             Statement stmt = conn.createStatement()) {
            stmt.execute("DROP TABLE IF EXISTS temp");
        }
    }
}