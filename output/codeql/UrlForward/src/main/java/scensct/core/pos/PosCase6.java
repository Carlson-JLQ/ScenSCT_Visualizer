package scensct.core.pos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PosCase6 {
    @GetMapping("/forward")
    public String forward(@RequestParam("page") String page) { // Added @RequestParam to mark as user input
        // Variable access without URL encoding guard for repeated decode
        String path = page;
        return "forward:" + path;
    }
}