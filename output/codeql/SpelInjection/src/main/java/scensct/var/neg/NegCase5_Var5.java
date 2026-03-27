// Direct flow from threat source to SpEL sink without additional taint steps.
package scensct.var.neg;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;
import javax.servlet.http.HttpServletRequest;

public class NegCase5_Var5 {
    // Variant 5: Split the flow across multiple statements with aliasing, and use a local variable for context.
    public void directFlow(HttpServletRequest request) {
        String source = request.getParameter("input");
        String expressionText = source;
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression(expressionText);
        SimpleEvaluationContext sec = SimpleEvaluationContext.forReadOnlyDataBinding().build();
        Object output = exp.getValue(sec);
        System.out.println(output);
    }
}