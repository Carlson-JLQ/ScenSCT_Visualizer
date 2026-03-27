// Threat source flows but does not reach any SpEL evaluation sink.
package scensct.var.neg;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class NegCase3_Var3 {
    public void handleRequest(HttpServletRequest request) {
        // Use Optional for intermediate processing
        Optional<String> inputOpt = Optional.ofNullable(request.getParameter("data"));
        inputOpt.map(String::toLowerCase)
                .filter(s -> !s.isEmpty())
                .ifPresentOrElse(
                        s -> System.out.println("Received: " + s),
                        () -> System.out.println("No data")
                );
        // No SpEL evaluation method invoked
    }
}