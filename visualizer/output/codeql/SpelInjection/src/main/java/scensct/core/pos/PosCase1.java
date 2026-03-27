// User-controlled string from HttpServletRequest flows into SpelExpressionParser.parseExpression and getValue without secure EvaluationContext should be flagged as SpEL injection.
package scensct.core.pos;

import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import javax.servlet.http.HttpServletRequest;

public class PosCase1 {
    public void evaluateUserInput(HttpServletRequest request) {
        String userInput = request.getParameter("input"); // User-controlled source
        SpelExpressionParser parser = new SpelExpressionParser();
        Expression expr = parser.parseExpression(userInput); // User input flows into expression parsing
        Object result = expr.getValue(); // Unsafe evaluation without secure EvaluationContext // [REPORTED LINE]
        System.out.println(result);
    }
}