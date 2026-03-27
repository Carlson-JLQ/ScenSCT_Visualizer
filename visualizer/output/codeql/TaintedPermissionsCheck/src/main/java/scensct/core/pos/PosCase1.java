// Scenario 1: A method call that performs a permissions check receives its first argument from a user-controlled source, creating a taint flow.
package scensct.core.pos;

import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class PosCase1 {
    public void checkUserPermission(HttpServletRequest request) {
        // User-controlled source: request.getParameter
        String permission = request.getParameter("perm");
        // Permissions check with tainted first argument
        Subject subject = SecurityUtils.getSubject();
        subject.checkPermission(permission);
    }
}