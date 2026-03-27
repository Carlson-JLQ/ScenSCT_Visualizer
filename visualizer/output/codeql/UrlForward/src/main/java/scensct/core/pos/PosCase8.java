// Tainted user input from a method call flows to a "forward:" sink; the path includes string prefixes without '?' or '#', no redirect prefixes, and variable accesses where a URL encoding guard exists but does not dominate the access node, making it ineffective should be flagged as untrusted URL forward.
package scensct.core.pos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.UnsupportedEncodingException;

@Controller
public class PosCase8 {
    @GetMapping("/forward")
    public String forward(@RequestParam("page") String page) {
        // Method call source
        String source = getInput(page);
        String path = "prefix/" + source;
        // Ineffective encoding guard
        if (Math.random() > 0.5) { // Non-dominating guard
            try {
                path = java.net.URLEncoder.encode(path, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                // ignore
            }
        }
        return "forward:" + path;
    }

    private String getInput(String input) {
        return input; // Taint propagation
    }
}