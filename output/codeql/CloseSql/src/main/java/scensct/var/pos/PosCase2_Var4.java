// Scenario 2: A java.sql.Statement is locally initialized and used directly as a receiver without being stored.
package scensct.var.pos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PosCase2_Var4 {
    public void test() throws SQLException {
        // Inline the connection creation and use a different variable name
        java.sql.Statement s = DriverManager.getConnection("jdbc:example:db").createStatement(); // [REPORTED LINE]
        s.executeQuery("SELECT 1"); // [REPORTED LINE]
        // No close
    }
}