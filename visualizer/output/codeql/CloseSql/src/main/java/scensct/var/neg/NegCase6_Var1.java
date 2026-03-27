// A SQL resource that is not locally initialized should not be flagged as unclosed.
package scensct.var.neg;

import java.sql.Connection;

public class NegCase6_Var1 {
    private Connection conn;
    
    public void test() {
        // Alias the field through a local variable, but still no initialization
        Connection localConn = this.conn;
        useConnection(localConn);
    }
    
    private void useConnection(Connection c) {
        // No local initialization
    }
}