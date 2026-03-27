// A non-method-call taint source (e.g., a method parameter) flows to a "forward:" sink; the path may involve variable accesses that are not guarded by a URL encoding check that controls repeated decode calls should be flagged as untrusted URL forward.
package scensct.ref.pos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PosCase6_FN1 {
    @GetMapping("/forward")
    public String forward(String page) { // Method parameter as source
        // Variable access without URL encoding guard for repeated decode
        String path = page;
        return "forward:" + path;
    }
}