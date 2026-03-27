// A locally initialized SQL resource with a transitive parent closeable resource that is a locally initialized ClassInstanceExpr with no arguments should not be flagged as unclosed.
package scensct.var.neg;

import java.sql.Connection;
import java.sql.Statement;

public class NegCase4_Var5 {
    static class CustomConnection implements AutoCloseable {
        public void close() throws Exception {}
    }
    
    static class Wrapper implements AutoCloseable {
        private final CustomConnection delegate;
        Wrapper(CustomConnection conn) { this.delegate = conn; }
        public void close() throws Exception { delegate.close(); }
    }
    
    public void test() throws Exception {
        // Variant 4: Wrap the parent resource in another AutoCloseable, but still no-arg initialization.
        // This tests if checker can handle wrapping layers.
        try (Wrapper wrapped = new Wrapper(new CustomConnection());
             Connection conn = java.sql.DriverManager.getConnection("jdbc:test");
             Statement stmt = conn.createStatement()) {
            stmt.addBatch("INSERT INTO test VALUES (1)");
        }
    }
}