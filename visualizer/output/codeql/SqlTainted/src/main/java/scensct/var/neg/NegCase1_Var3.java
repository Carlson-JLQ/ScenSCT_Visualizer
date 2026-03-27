// Constant string source should not be flagged as SQL injection.
package scensct.var.neg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NegCase1_Var3 {
    public static void main(String[] args) throws SQLException {
        // Variant 3: Constant via String.format with literals
        String table = "products";
        String query = String.format("SELECT * FROM %s", table);
        Connection conn = null;
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.executeQuery();
    }
}