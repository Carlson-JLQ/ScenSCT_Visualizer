// A non-method-call taint source (e.g., a field) flows directly to a default URL forward sink without any sanitization barriers should be flagged as untrusted URL forward.
package scensct.ref.pos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PosCase5_FN1 {
    private String page = "userInput"; // Field as taint source

    @GetMapping("/forward")
    public String forward() {
        // Direct flow from field to forward sink
        return "forward:" + page;
    }
}