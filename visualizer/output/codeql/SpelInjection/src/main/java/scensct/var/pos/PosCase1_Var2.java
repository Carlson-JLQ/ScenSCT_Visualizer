// User-controlled string from HttpServletRequest flows into SpelExpressionParser.parseExpression and getValue without secure EvaluationContext should be flagged as SpEL injection.
package scensct.var.pos;

import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import javax.servlet.http.HttpServletRequest;

public class PosCase1_Var2 {
    // Variant 2: Extract parsing and evaluation into a helper method
    public void evaluateUserInput(HttpServletRequest request) {
        String userInput = request.getParameter("input");
        evaluateExpression(userInput);
    }

    private void evaluateExpression(String expressionString) {
        SpelExpressionParser parser = new SpelExpressionParser();
        Expression expr = parser.parseExpression(expressionString);
        Object val = expr.getValue(); // [REPORTED LINE]
        System.out.println(val);
    }
}