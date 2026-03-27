// A locally initialized SQL resource nested within at least two other closeable resources should not be flagged as unclosed.
package scensct.var.neg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class NegCase2_Var3 {
    public void test() throws Exception {
        // Extract statement creation to a helper, but keep ResultSet inside the try
        try (Connection conn = DriverManager.getConnection("jdbc:test");
             Statement stmt = createStatement(conn)) {
            ResultSet rs = executeSelect(stmt);
        }
    }

    private Statement createStatement(Connection c) throws Exception {
        return c.createStatement();
    }

    private ResultSet executeSelect(Statement s) throws Exception {
        return s.executeQuery("SELECT 1");
    }
}