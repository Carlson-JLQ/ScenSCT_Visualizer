// User-controlled string from HttpServletRequest flows into SpelExpressionParser.parseExpression and getValue without secure EvaluationContext should be flagged as SpEL injection.
package scensct.var.pos;

import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import javax.servlet.http.HttpServletRequest;

public class PosCase1_Var1 {
    public void evaluateUserInput(HttpServletRequest request) {
        // Variant 1: Introduce temporary variable and conditional that does not block flow
        String param = request.getParameter("input");
        String userExpression = param != null ? param : "default";
        SpelExpressionParser parser = new SpelExpressionParser();
        Expression expr = parser.parseExpression(userExpression);
        if (expr != null) {
            Object result = expr.getValue(); // [REPORTED LINE]
            System.out.println("Result: " + result);
        }
    }
}