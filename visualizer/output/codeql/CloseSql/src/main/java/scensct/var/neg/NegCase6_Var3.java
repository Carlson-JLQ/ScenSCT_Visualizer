// A SQL resource that is not locally initialized should not be flagged as unclosed.
package scensct.var.neg;

import java.sql.Connection;

public class NegCase6_Var3 {
    private Connection conn;
    
    public void test() {
        // Extract field access into a helper method that returns the field
        Connection c = getConnection();
        useConnection(c);
    }
    
    private Connection getConnection() {
        return conn; // returns field, does not create
    }
    
    private void useConnection(Connection c) {
        // No local initialization
    }
}