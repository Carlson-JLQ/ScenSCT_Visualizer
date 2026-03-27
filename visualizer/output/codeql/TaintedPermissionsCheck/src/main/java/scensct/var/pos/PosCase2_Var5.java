// Scenario 2: A WildCardPermission constructor call receives its first argument from a user-controlled source, creating a taint flow.
package scensct.var.pos;

import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.authz.permission.WildcardPermission;

public class PosCase2_Var5 {
    public void createPermission(HttpServletRequest request) {
        // Inline constructor call with direct argument
        new WildcardPermission(request.getParameter("perm")); // [REPORTED LINE]
    }
}