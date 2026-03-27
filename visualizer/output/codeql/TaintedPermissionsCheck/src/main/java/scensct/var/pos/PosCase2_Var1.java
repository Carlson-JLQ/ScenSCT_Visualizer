// Scenario 2: A WildCardPermission constructor call receives its first argument from a user-controlled source, creating a taint flow.
package scensct.var.pos;

import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.authz.permission.WildcardPermission;

public class PosCase2_Var1 {
    public void createPermission(HttpServletRequest request) {
        // Extract tainted value via a helper method
        String perm = getPermissionString(request);
        // Constructor call remains
        WildcardPermission wp = new WildcardPermission(perm); // [REPORTED LINE]
    }
    
    private String getPermissionString(HttpServletRequest req) {
        return req.getParameter("perm");
    }
}