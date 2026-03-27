// A non-method-call taint source flows to a "forward:" sink; the path includes no string prefixes, may include non-"redirect:" redirect prefixes, and variable accesses where a URL encoding guard exists but does not dominate the access node, rendering it ineffective should be flagged as untrusted URL forward.
package scensct.ref.pos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.io.UnsupportedEncodingException;

@Controller
public class PosCase7_FN1 {
    @GetMapping("/forward")
    public String forward(String page) { // Parameter source
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