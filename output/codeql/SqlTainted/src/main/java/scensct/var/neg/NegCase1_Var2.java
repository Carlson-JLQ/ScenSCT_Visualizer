// Constant string source should not be flagged as SQL injection.
package scensct.var.neg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NegCase1_Var2 {
    public static void main(String[] args) throws SQLException {
        // Variant 2: Constant from a private static helper method
        String sql = getConstantQuery();
        Connection conn = null;
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.executeQuery();
    }
    
    private static String getConstantQuery() {
        return "SELECT * FROM products";
    }
}