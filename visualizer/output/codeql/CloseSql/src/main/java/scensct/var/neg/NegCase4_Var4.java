// A locally initialized SQL resource with a transitive parent closeable resource that is a locally initialized ClassInstanceExpr with no arguments should not be flagged as unclosed.
package scensct.var.neg;

import java.sql.Connection;
import java.sql.Statement;

public class NegCase4_Var4 {
    static class CustomConnection implements AutoCloseable {
        public void close() throws Exception {}
    }
    
    public void test() throws Exception {
        // Variant 3: Nest try-with-resources, with parent in outer try.
        // This tests transitive safety across nested try blocks.
        try (CustomConnection customConn = new CustomConnection()) {
            try (Connection conn = java.sql.DriverManager.getConnection("jdbc:test");
                 Statement stmt = conn.createStatement()) {
                stmt.executeQuery("SELECT * FROM table");
            }
        }
    }
}