// Flow with extra taint steps present but not connecting source to sink.
package scensct.core.neg;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import javax.servlet.http.HttpServletRequest;

public class NegCase6 {
    public void indirectFlow(HttpServletRequest request) {
        String userInput = request.getParameter("input");
        // Additional taint step pattern (method call) that does not propagate taint to the sink.
        String intermediate = userInput.toUpperCase();
        ExpressionParser parser = new SpelExpressionParser();
        // Sink uses a constant, not the tainted intermediate.
        Expression expr = parser.parseExpression("'constant'");
        Object result = expr.getValue();
        System.out.println(result);
        // Taint steps exist but do not connect source to sink in this path.
    }
}