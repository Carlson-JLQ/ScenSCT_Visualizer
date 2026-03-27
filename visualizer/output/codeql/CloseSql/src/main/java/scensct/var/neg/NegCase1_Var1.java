// A locally initialized SQL resource where there exists another locally initialized closeable parent resource should not be flagged as unclosed.
package scensct.var.neg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class NegCase1_Var1 {
    public void test() throws Exception {
        // Variant 1: Reorder resources and rename variables
        try (Connection connection = DriverManager.getConnection("jdbc:test");
             Statement sqlStatement = connection.createStatement()) {
            // Usage unchanged
            sqlStatement.execute("SELECT 1");
        }
    }
}