// Scenario 2: A WildCardPermission constructor call receives its first argument from a user-controlled source, creating a taint flow.
package scensct.core.pos;

import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.authz.permission.WildcardPermission;

public class PosCase2 {
    public void createPermission(HttpServletRequest request) {
        // User-controlled source: request.getParameter
        String permissionString = request.getParameter("perm");
        // WildCardPermission constructor with tainted first argument
        WildcardPermission perm = new WildcardPermission(permissionString); // [REPORTED LINE]
    }
}