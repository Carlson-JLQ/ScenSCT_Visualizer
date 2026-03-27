// User-controlled string from HttpServletRequest flows into SpelExpressionParser.parseExpression and getValue without secure EvaluationContext should be flagged as SpEL injection.
package scensct.var.pos;

import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import javax.servlet.http.HttpServletRequest;

public class PosCase1_Var5 {
    // Variant 5: Restructure with a loop and intermediate assignment
    public void evaluateUserInput(HttpServletRequest request) {
        String[] inputs = { request.getParameter("input") };
        SpelExpressionParser parser = new SpelExpressionParser();
        for (String input : inputs) {
            if (input == null) continue;
            Expression expr = parser.parseExpression(input.trim());
            Object output = expr.getValue(); // [REPORTED LINE]
            System.out.println(output);
            break;
        }
    }
}