// Independent threat source and SpEL sink should not be flagged as injection.
package scensct.var.neg;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import javax.servlet.http.HttpServletRequest;

public class NegCase2_Var2 {
    public void process(HttpServletRequest request) {
        // Threat source captured but not used in SpEL
        String userData = request.getParameter("input");
        // SpEL evaluation with a literal that is built from safe parts
        String safeLiteral = "sa" + "fe";
        ExpressionParser parser = new SpelExpressionParser();
        Expression expr = parser.parseExpression(safeLiteral);
        Object result = expr.getValue();
        System.out.println(result);
    }
}