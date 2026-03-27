// Scenario 4: A java.sql.Connection is locally initialized, used directly without storage, has no parent after exemptions, and is not closed.
package scensct.var.pos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PosCase4_Var4 {
    public void test() throws SQLException {
        // Variant 4: Use DriverManager.getConnection with extra parameters, still not closed.
        String url = "jdbc:example:db";
        String user = "sa";
        String pass = "";
        DriverManager.getConnection(url, user, pass).createStatement(); // [REPORTED LINE]
    }
}