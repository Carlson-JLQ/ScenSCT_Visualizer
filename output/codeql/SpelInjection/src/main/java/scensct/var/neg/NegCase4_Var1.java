// Threat source flows to SpEL expression but evaluation uses safe context.
package scensct.var.neg;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import javax.servlet.http.HttpServletRequest;

public class NegCase4_Var1 {
    public void evaluate(HttpServletRequest request) {
        ExpressionParser parser = new SpelExpressionParser();
        // Parse constant expression first, before even getting input.
        Expression expr = parser.parseExpression("safeVar");
        
        String userInput = request.getParameter("expr");
        StandardEvaluationContext ctx = new StandardEvaluationContext();
        // Use an alias reference for the same input.
        String valueToSet = userInput;
        ctx.setVariable("safeVar", valueToSet);
        
        // Evaluation with the prepared context.
        Object result = expr.getValue(ctx);
        System.out.println(result);
    }
}