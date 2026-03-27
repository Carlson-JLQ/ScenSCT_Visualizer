// A SQL resource that is not locally initialized should not be flagged as unclosed.
package scensct.core.neg;

import java.sql.Connection;

public class NegCase6 {
    private Connection conn; // Field, not locally initialized
    
    public void test() {
        // SQL resource passed as parameter or field, not locally initialized in this method
        useConnection(conn);
    }
    
    private void useConnection(Connection c) {
        // No local initialization
    }
}