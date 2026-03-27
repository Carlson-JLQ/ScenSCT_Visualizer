// Constant string source should not be flagged as SQL injection.
package scensct.var.neg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NegCase1_Var5 {
    public static void main(String[] args) throws SQLException {
        // Variant 5: Constant with try-with-resources (sink inside)
        String constantSource = "SELECT * FROM products";
        Connection conn = null;
        try (PreparedStatement stmt = conn.prepareStatement(constantSource)) {
            stmt.executeQuery();
        }
    }
}