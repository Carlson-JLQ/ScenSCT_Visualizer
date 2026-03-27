// Direct flow from threat source to SpEL sink without additional taint steps.
package scensct.var.neg;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;
import javax.servlet.http.HttpServletRequest;

public class NegCase5_Var2 {
    // Variant 2: Introduce a temporary variable and a conditional branch that does not affect the flow.
    public void directFlow(HttpServletRequest request) {
        String raw = request.getParameter("input");
        String userInput = raw != null ? raw.trim() : "";
        ExpressionParser parser = new SpelExpressionParser();
        Expression expr = parser.parseExpression(userInput);
        SimpleEvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();
        if (expr != null) {
            Object result = expr.getValue(context);
            System.out.println("Result: " + result);
        }
    }
}