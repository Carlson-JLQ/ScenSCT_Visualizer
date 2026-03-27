// A taint flow from an ActiveThreatModelSource to a non-forward operation within a Spring request mapping method should not be flagged.
package scensct.core.neg;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;

public class NegCase5 {
    @GetMapping("/path")
    public String handleRequest(@RequestParam("page") String page, HttpServletRequest request) {
        // Source: ActiveThreatModelSource via @RequestParam
        String userInput = page;
        // Sink: return a view name without "forward:" prefix, so not a forward operation
        return userInput; // This is a view name, not a forward
    }
}