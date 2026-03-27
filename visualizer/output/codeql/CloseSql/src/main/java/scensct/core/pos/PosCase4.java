// Scenario 4: A java.sql.Connection is locally initialized, used directly without storage, has no parent after exemptions, and is not closed.
package scensct.core.pos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PosCase4 {
    public void test() throws SQLException {
        // Locally initialized Connection used directly, not stored, no parent after exemptions.
        DriverManager.getConnection("jdbc:example:db").createStatement(); // [REPORTED LINE]
        // No close() call on the Connection before method exit.
    }
}