// Direct flow from threat source to SpEL sink without additional taint steps.
package scensct.core.neg;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;
import javax.servlet.http.HttpServletRequest;

public class NegCase5 {
    public void directFlow(HttpServletRequest request) {
        // Recognized threat source.
        String userInput = request.getParameter("input");
        ExpressionParser parser = new SpelExpressionParser();
        // Direct flow: userInput used as expression string.
        Expression expr = parser.parseExpression(userInput);
        // Safe evaluation sink using SimpleEvaluationContext.
        SimpleEvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();
        Object result = expr.getValue(context); // [REPORTED LINE]
        System.out.println(result);
    }
}