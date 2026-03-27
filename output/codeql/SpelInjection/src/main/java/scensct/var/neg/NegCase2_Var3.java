// Independent threat source and SpEL sink should not be flagged as injection.
package scensct.var.neg;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import javax.servlet.http.HttpServletRequest;

public class NegCase2_Var3 {
    public void process(HttpServletRequest request) {
        // Threat source exists
        String input = request.getParameter("input");
        // Independent SpEL evaluation inside a conditional block
        if (input != null) {
            // This block does not use input in the expression
            ExpressionParser parser = new SpelExpressionParser();
            Expression expr = parser.parseExpression("T(java.lang.Math).random()");
            Object value = expr.getValue();
            System.out.println(value);
        } else {
            System.out.println("No input");
        }
    }
}