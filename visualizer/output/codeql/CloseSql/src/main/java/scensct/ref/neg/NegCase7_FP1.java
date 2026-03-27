// A locally initialized SQL ResultSet obtained via a method call on a Statement variable, where Statement is a transitive parent closeable resource, should not be flagged as unclosed.
package scensct.ref.neg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class NegCase7_FP1 {
    public void test() throws Exception {
        // Statement as closeable resource (transitive parent)
        Connection conn = DriverManager.getConnection("jdbc:test");
        Statement stmt = conn.createStatement(); // [REPORTED LINE]
        // Locally initialized ResultSet via method call on Statement
        ResultSet rs = stmt.executeQuery("SELECT 1"); // [REPORTED LINE]
    }
}