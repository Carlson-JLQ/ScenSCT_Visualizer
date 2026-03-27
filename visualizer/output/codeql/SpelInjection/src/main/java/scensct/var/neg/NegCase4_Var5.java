// Threat source flows to SpEL expression but evaluation uses safe context.
package scensct.var.neg;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import javax.servlet.http.HttpServletRequest;

public class NegCase4_Var5 {
    public void evaluate(HttpServletRequest request) {
        String userInput = request.getParameter("expr");
        ExpressionParser parser = new SpelExpressionParser();
        // Parse based on a flag that is always true.
        boolean useSafe = true;
        Expression expr = useSafe ? parser.parseExpression("safeVar") : parser.parseExpression(userInput);
        
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setVariable("safeVar", userInput);
        // Only evaluate if expr is not null (always true here).
        if (expr != null) {
            Object result = expr.getValue(context);
            System.out.println(result);
        }
    }
}