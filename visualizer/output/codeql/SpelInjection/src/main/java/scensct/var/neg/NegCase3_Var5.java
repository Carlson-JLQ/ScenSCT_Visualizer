// Threat source flows but does not reach any SpEL evaluation sink.
package scensct.var.neg;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class NegCase3_Var5 {
    public void handleRequest(HttpServletRequest request) {
        List<String> inputs = new ArrayList<>();
        inputs.add(request.getParameter("data"));
        // Add more dummy sources that also don't reach SpEL
        inputs.add("static");
        // Process list but avoid SpEL sinks
        for (String s : inputs) {
            if (s != null && s.contains("test")) {
                System.out.println("Filtered: " + s);
            }
        }
        // No SpEL evaluation anywhere
    }
}