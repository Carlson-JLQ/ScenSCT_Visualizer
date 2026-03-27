// Tainted user input from a method call flows to a "forward:" sink; the path includes string prefixes without '?' or '#', non-"redirect:" redirect prefixes, and variable accesses not guarded by URL encoding checks should be flagged as untrusted URL forward.
package scensct.core.pos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PosCase3 {
    @GetMapping("/forward")
    public String forward(@RequestParam("page") String page) {
        // Method call source, variable access, no encoding guard
        String source = getPage(page);
        String path = "pre/" + source;
        return "forward:" + path;
    }

    private String getPage(String input) {
        return input; // Simple taint propagation
    }
}