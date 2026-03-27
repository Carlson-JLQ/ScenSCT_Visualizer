// User-controlled string from HttpServletRequest flows into SpelExpressionParser.parseExpression and getValue without secure EvaluationContext should be flagged as SpEL injection.
package scensct.var.pos;

import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import javax.servlet.http.HttpServletRequest;

public class PosCase1_Var4 {
    // Variant 4: Wrap in try-catch-finally, but flow remains
    public void evaluateUserInput(HttpServletRequest request) {
        SpelExpressionParser parser = new SpelExpressionParser();
        try {
            String userInput = request.getParameter("input");
            Expression expr = parser.parseExpression(userInput);
            Object result = expr.getValue(); // [REPORTED LINE]
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Evaluation attempted");
        }
    }
}