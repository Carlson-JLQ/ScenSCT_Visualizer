// Threat source flows to SpEL expression but evaluation uses safe context.
package scensct.ref.neg;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import javax.servlet.http.HttpServletRequest;

public class NegCase4_FP1 {
    public void evaluate(HttpServletRequest request) {
        String userInput = request.getParameter("expr");
        ExpressionParser parser = new SpelExpressionParser();
        Expression expr = parser.parseExpression(userInput);
        // Safe evaluation context with no user-controlled root object or variables.
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setVariable("safeVar", "constant");
        // Evaluation uses fixed safe context, not dangerous default.
        Object result = expr.getValue(context); // [REPORTED LINE]
        System.out.println(result);
    }
}