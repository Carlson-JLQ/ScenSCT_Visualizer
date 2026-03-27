// Tainted user input from a method call flows to a default forward sink; the path includes string prefixes without '?' or '#', no redirect prefixes, and variable accesses not guarded by URL encoding checks should be flagged as untrusted URL forward.
package scensct.core.pos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PosCase4 {
    @GetMapping("/forward")
    public String forward(@RequestParam("page") String page) {
        // Method call source, default forward sink (no redirect prefix)
        String source = process(page);
        String path = "views/" + source;
        return "forward:" + path;
    }

    private String process(String input) {
        return input; // Taint propagation
    }
}