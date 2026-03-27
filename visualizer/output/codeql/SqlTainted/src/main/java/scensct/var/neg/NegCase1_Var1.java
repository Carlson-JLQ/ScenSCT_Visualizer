// Constant string source should not be flagged as SQL injection.
package scensct.var.neg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NegCase1_Var1 {
    public static void main(String[] args) throws SQLException {
        // Variant 1: Constant split and concatenated
        final String part1 = "SELECT * ";
        String part2 = "FROM products";
        String query = part1 + part2;
        Connection conn = null;
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.executeQuery();
    }
}