// Scenario 2: A WildCardPermission constructor call receives its first argument from a user-controlled source, creating a taint flow.
package scensct.var.pos;

import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.authz.permission.WildcardPermission;

public class PosCase2_Var3 {
    public void createPermission(HttpServletRequest request) {
        // Split taint flow across multiple variables
        String param = request.getParameter("perm");
        String permission = param;
        // Introduce a temporary that doesn't break taint
        String finalPerm = permission.trim();
        WildcardPermission perm = new WildcardPermission(finalPerm); // [REPORTED LINE]
    }
}