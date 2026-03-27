// Threat source flows to SpEL expression but evaluation uses safe context.
package scensct.var.neg;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import javax.servlet.http.HttpServletRequest;

public class NegCase4_Var3 {
    public void evaluate(HttpServletRequest request) {
        String userInput = request.getParameter("expr");
        Expression expr = makeConstantExpression();
        StandardEvaluationContext context = createContextWithVariable("safeVar", userInput);
        Object result = expr.getValue(context);
        System.out.println(result);
    }
    
    private Expression makeConstantExpression() {
        ExpressionParser parser = new SpelExpressionParser();
        return parser.parseExpression("safeVar");
    }
    
    private StandardEvaluationContext createContextWithVariable(String varName, Object value) {
        StandardEvaluationContext ctx = new StandardEvaluationContext();
        ctx.setVariable(varName, value);
        return ctx;
    }
}