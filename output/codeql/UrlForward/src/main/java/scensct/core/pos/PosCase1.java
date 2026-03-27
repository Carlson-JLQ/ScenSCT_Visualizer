// User-provided input flows directly into a Spring MVC controller method that returns a "forward:" string without any sanitization or encoding barriers should be flagged as untrusted URL forward.
package scensct.core.pos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PosCase1 {
    @GetMapping("/forward")
    public String forward(@RequestParam("page") String page) {
        // Direct flow from user input to forward sink
        return "forward:" + page;
    }
}