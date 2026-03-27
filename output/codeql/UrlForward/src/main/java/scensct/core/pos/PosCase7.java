package scensct.core.pos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.UnsupportedEncodingException;

@Controller
public class PosCase7 {
    @GetMapping("/forward")
    public String forward(@RequestParam("page") String page) { // Added @RequestParam to mark as user input
        String path = page;
        // Ineffective guard (does not dominate the access node)
        if (someCondition()) {
            try {
                path = java.net.URLEncoder.encode(path, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                // ignore
            }
        }
        // Guard does not dominate this return, so ineffective
        return "forward:" + path;
    }

    private boolean someCondition() {
        return false; // Guard condition false, making guard ineffective
    }
}