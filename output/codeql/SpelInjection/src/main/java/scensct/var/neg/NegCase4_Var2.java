// Threat source flows to SpEL expression but evaluation uses safe context.
package scensct.var.neg;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import javax.servlet.http.HttpServletRequest;

public class NegCase4_Var2 {
    public void evaluate(HttpServletRequest request) {
        String userInput = request.getParameter("expr");
        ExpressionParser parser = new SpelExpressionParser();
        Expression expr = parser.parseExpression("safeVar");
        StandardEvaluationContext context = null;
        try {
            context = new StandardEvaluationContext();
            context.setVariable("safeVar", userInput);
        } finally {
            // Ensure evaluation happens even if something earlier threw.
            if (context != null) {
                Object result = expr.getValue(context);
                System.out.println(result);
            }
        }
    }
}