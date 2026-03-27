// A Java source file containing a method call where the method name is not "addCookie" OR the method's declaring type is not javax.servlet.http.HttpServletResponse or jakarta.servlet.http.HttpServletResponse should not be flagged as insecure cookie.
package scensct.var.neg;

import javax.servlet.http.Cookie;

public class NegCase2_Var5 {
    // Variant 5: Control-flow with loops and switches, dead code
    public void process(Object obj) {
        int mode = 1;
        switch (mode) {
            case 1:
                // This block always executes
                if (obj instanceof javax.servlet.http.HttpServletResponse) {
                    javax.servlet.http.HttpServletResponse r = 
                        (javax.servlet.http.HttpServletResponse) obj;
                    for (int i = 0; i < 3; i++) {
                        // Loop might confuse flow analysis, but method is not addCookie
                        r.setHeader("Set-Cookie", "loop=" + i + "; Secure");
                    }
                }
                break;
            default:
                // Dead code: includes a call to addCookie on HttpServletResponse?
                // But we ensure it's unreachable and on a different type anyway
                AnotherClass dead = new AnotherClass();
                dead.addCookie(null);
        }
        
        // Cookie created via array
        Cookie[] cookies = {new Cookie("k", "v")};
        cookies[0].setSecure(true);
        
        // Pass to a consumer that expects Cookie but type is not HttpServletResponse
        java.util.function.Consumer<Cookie> consumer = new AnotherClass()::addCookie;
        consumer.accept(cookies[0]);
    }
    
    static class AnotherClass {
        public void addCookie(Cookie cookie) {
            // Custom
        }
    }
}