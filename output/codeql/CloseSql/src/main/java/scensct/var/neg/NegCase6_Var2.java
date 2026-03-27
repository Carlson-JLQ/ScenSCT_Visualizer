// A SQL resource that is not locally initialized should not be flagged as unclosed.
package scensct.var.neg;

import java.sql.Connection;

public class NegCase6_Var2 {
    private Connection conn;
    
    public void test() {
        // Pass the field via a conditional that doesn't affect initialization
        if (conn != null) {
            useConnection(conn);
        } else {
            // Still no initialization, just a different path
            useConnection(null);
        }
    }
    
    private void useConnection(Connection c) {
        // No local initialization
    }
}