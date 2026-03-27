// Tainted user input flows to a "forward:" sink; the path includes a string prefix that does not contain '?' or '#', and may include a non-"redirect:" redirect prefix, but no proper sanitization barriers exist should be flagged as untrusted URL forward.
package scensct.core.pos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PosCase2 {
    @GetMapping("/forward")
    public String forward(@RequestParam("page") String page) {
        // User input with string prefix, no sanitization
        String path = "prefix/" + page;
        return "forward:" + path;
    }
}