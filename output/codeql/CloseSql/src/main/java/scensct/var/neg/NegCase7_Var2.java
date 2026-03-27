// A locally initialized SQL ResultSet obtained via a method call on a Statement variable, where Statement is a transitive parent closeable resource, should not be flagged as unclosed.
package scensct.var.neg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class NegCase7_Var2 {
    public void test() throws Exception {
        try (Connection conn = DriverManager.getConnection("jdbc:test");
             Statement stmt = conn.createStatement()) {
            // ResultSet obtained via helper, still from stmt
            ResultSet rs = getResultSet(stmt);
        }
    }

    private ResultSet getResultSet(Statement s) throws Exception {
        // The ResultSet is still initialized via method call on the Statement
        return s.executeQuery("SELECT 1");
    }
}