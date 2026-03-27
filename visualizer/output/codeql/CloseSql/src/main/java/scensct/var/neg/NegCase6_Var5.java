// A SQL resource that is not locally initialized should not be flagged as unclosed.
package scensct.var.neg;

import java.sql.Connection;

public class NegCase6_Var5 {
    private Connection conn;
    
    public void test() {
        // Wrap field access in a try-catch, but no initialization
        try {
            useConnection(conn);
        } catch (RuntimeException e) {
            // ignore
        }
    }
    
    private void useConnection(Connection c) {
        // No local initialization
    }
}