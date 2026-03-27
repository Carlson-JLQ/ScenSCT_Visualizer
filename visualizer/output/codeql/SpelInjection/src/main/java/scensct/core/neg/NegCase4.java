// Threat source flows to SpEL expression but evaluation uses safe context.
package scensct.core.neg;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import javax.servlet.http.HttpServletRequest;

public class NegCase4 {
    public void evaluate(HttpServletRequest request) {
        String userInput = request.getParameter("expr");
        ExpressionParser parser = new SpelExpressionParser();
        // Parse a constant expression, not user input.
        Expression expr = parser.parseExpression("safeVar");
        // Safe evaluation context with user input as a variable value.
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setVariable("safeVar", userInput);
        // Evaluation uses fixed safe context, not dangerous default.
        Object result = expr.getValue(context); // [REPORTED LINE]
        System.out.println(result);
    }
}