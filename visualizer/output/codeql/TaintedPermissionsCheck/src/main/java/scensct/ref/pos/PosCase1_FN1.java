// Scenario 1: A method call that performs a permissions check receives its first argument from a user-controlled source, creating a taint flow.
package scensct.ref.pos;

import javax.servlet.http.HttpServletRequest;

public class PosCase1_FN1 {
    public void checkUserPermission(HttpServletRequest request) {
        // User-controlled source: request.getParameter
        String permission = request.getParameter("perm");
        // Permissions check with tainted first argument
        checkPermission(permission);
    }

    // Simulated permissions check method
    private void checkPermission(String perm) {
        // Logic to check permission
    }
}