// Constant string source should not be flagged as SQL injection.
package scensct.var.neg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NegCase1_Var4 {
    public static void main(String[] args) throws SQLException {
        // Variant 4: Constant inside trivial if-branch
        String sql;
        if (true) {
            sql = "SELECT * FROM products";
        } else {
            sql = "";
        }
        Connection conn = null;
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.executeQuery();
    }
}