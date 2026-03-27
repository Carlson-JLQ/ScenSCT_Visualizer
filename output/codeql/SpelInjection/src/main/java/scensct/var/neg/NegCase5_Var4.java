// Direct flow from threat source to SpEL sink without additional taint steps.
package scensct.var.neg;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;
import javax.servlet.http.HttpServletRequest;

public class NegCase5_Var4 {
    // Variant 4: Inline the context creation and add a try-catch block (control-flow restructuring).
    public void directFlow(HttpServletRequest request) {
        String userInput = request.getParameter("input");
        ExpressionParser parser = new SpelExpressionParser();
        Expression expr = parser.parseExpression(userInput);
        try {
            Object result = expr.getValue(SimpleEvaluationContext.forReadOnlyDataBinding().build());
            System.out.println(result);
        } catch (Exception e) {
            System.err.println("Evaluation failed: " + e.getMessage());
        }
    }
}