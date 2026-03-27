// A taint flow from an ActiveThreatModelSource to a URL forward sink passing through a "redirect:" prefix should not be flagged.
package scensct.core.neg;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public class NegCase6 {
    @GetMapping("/test")
    public ModelAndView handle(@RequestParam("path") String path) {
        // Source: ActiveThreatModelSource via @RequestParam
        String userInput = path;
        // Flow passes through a "redirect:" prefix operation
        String redirectPath = "redirect:" + userInput;
        // Sink: ModelAndView constructor with redirect prefix, not a forward
        return new ModelAndView(redirectPath);
    }
}