// Direct flow from threat source to SpEL sink without additional taint steps.
package scensct.var.neg;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;
import javax.servlet.http.HttpServletRequest;

public class NegCase5_Var1 {
    // Variant 1: Extract parsing and evaluation into a helper method, but keep the same safe context.
    public void directFlow(HttpServletRequest request) {
        String userInput = request.getParameter("input");
        evaluateSafeExpression(userInput);
    }

    private void evaluateSafeExpression(String expressionStr) {
        ExpressionParser parser = new SpelExpressionParser();
        Expression expr = parser.parseExpression(expressionStr);
        SimpleEvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();
        Object result = expr.getValue(context);
        System.out.println(result);
    }
}