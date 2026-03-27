package scensct.core.pos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PosCase5 {
    private String page; // Field as taint source, now uninitialized

    @GetMapping("/forward")
    public String forward(@RequestParam("page") String userInput) { // Added parameter to receive user input
        page = userInput; // Field assigned from tainted source
        // Direct flow from field to forward sink
        return "forward:" + page;
    }
}