// A locally initialized SQL resource nested within at least two other closeable resources should not be flagged as unclosed.
package scensct.var.neg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class NegCase2_Var5 {
    public void test() throws Exception {
        // Use PreparedStatement instead of Statement, still a closeable parent
        try (Connection conn = DriverManager.getConnection("jdbc:test");
             PreparedStatement pstmt = conn.prepareStatement("SELECT 1")) {
            ResultSet rs = pstmt.executeQuery();
            // ResultSet is nested under pstmt, which is nested under conn
        }
    }
}