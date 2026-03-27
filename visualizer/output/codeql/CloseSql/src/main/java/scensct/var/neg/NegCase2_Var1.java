// A locally initialized SQL resource nested within at least two other closeable resources should not be flagged as unclosed.
package scensct.var.neg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class NegCase2_Var1 {
    public void test() throws Exception {
        // Reorder resources and rename variables
        try (Connection c = DriverManager.getConnection("jdbc:test");
             Statement s = c.createStatement()) {
            ResultSet results = s.executeQuery("SELECT id FROM dummy");
            // No explicit close - still nested under s
        }
    }
}