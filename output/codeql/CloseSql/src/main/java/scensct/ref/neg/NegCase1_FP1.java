// A locally initialized SQL resource where there exists another locally initialized closeable parent resource should not be flagged as unclosed.
package scensct.ref.neg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class NegCase1_FP1 {
    public void test() throws Exception {
        // Locally initialized closeable parent resource (Connection)
        Connection conn = DriverManager.getConnection("jdbc:test");
        // Locally initialized SQL resource (Statement) with transitive parent via closeableInit
        Statement stmt = conn.createStatement(); // [REPORTED LINE]
        // Both resources are closeable; parent existence makes this a negative scenario
    }
}