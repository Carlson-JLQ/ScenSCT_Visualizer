// Independent threat source and SpEL sink should not be flagged as injection.
package scensct.var.neg;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import javax.servlet.http.HttpServletRequest;

public class NegCase2_Var5 {
    public void process(HttpServletRequest request) {
        // Threat source stored but not used in SpEL
        String threat = request.getParameter("input");
        // SpEL evaluation with a safe numeric constant
        ExpressionParser parser = new SpelExpressionParser();
        Expression expr = parser.parseExpression("42");
        Number result = (Number) expr.getValue();
        System.out.println("Answer: " + result.intValue());
    }
}