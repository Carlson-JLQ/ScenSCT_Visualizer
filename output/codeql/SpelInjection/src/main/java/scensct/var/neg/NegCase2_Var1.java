// Independent threat source and SpEL sink should not be flagged as injection.
package scensct.var.neg;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import javax.servlet.http.HttpServletRequest;

public class NegCase2_Var1 {
    public void process(HttpServletRequest request) {
        // Threat source: user input from request
        String param = request.getParameter("input");
        // Independent safe SpEL evaluation using a helper method
        evaluateSafeExpression();
    }

    private void evaluateSafeExpression() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression expr = parser.parseExpression("'constant'");
        Object val = expr.getValue();
        System.out.println("Result: " + val);
    }
}