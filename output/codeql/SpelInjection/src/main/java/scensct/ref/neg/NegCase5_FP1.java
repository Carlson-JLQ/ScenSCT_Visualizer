// Direct flow from threat source to SpEL sink without additional taint steps.
package scensct.ref.neg;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import javax.servlet.http.HttpServletRequest;

public class NegCase5_FP1 {
    public void directFlow(HttpServletRequest request) {
        // Recognized threat source.
        String userInput = request.getParameter("input");
        ExpressionParser parser = new SpelExpressionParser();
        // Direct flow: userInput used as expression string.
        Expression expr = parser.parseExpression(userInput);
        // Dangerous evaluation sink.
        Object result = expr.getValue(); // [REPORTED LINE]
        System.out.println(result);
    }
}