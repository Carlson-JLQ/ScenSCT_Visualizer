// Constant string source should not be flagged as SQL injection.
package scensct.core.neg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NegCase1 {
    public static void main(String[] args) throws SQLException {
        // Scenario: Source is a constant string, not user-controlled.
        String constantSource = "SELECT * FROM products";
        Connection conn = null; // Assume initialized
        // Flow from constant source to SQL sink, no sanitization needed.
        PreparedStatement stmt = conn.prepareStatement(constantSource);
        stmt.executeQuery();
    }
}