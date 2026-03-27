// Independent threat source and SpEL sink should not be flagged as injection.
package scensct.var.neg;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import javax.servlet.http.HttpServletRequest;

public class NegCase2_Var4 {
    private ExpressionParser parser = new SpelExpressionParser();

    public void process(HttpServletRequest request) {
        // Threat source
        String userInput = request.getParameter("input");
        // Safe expression evaluation using a class field
        evaluateConstantExpression();
    }

    private void evaluateConstantExpression() {
        Expression expr = parser.parseExpression("'safeString'");
        Object result = expr.getValue();
        System.out.println(result);
    }
}