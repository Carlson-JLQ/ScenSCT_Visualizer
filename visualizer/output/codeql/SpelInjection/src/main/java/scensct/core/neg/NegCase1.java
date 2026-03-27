// Constant string source should not be flagged as SpEL injection threat.
package scensct.core.neg;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class NegCase1 {
    public static void main(String[] args) {
        // Source is a constant string, not a recognized threat source.
        String safeInput = "1 + 2";
        ExpressionParser parser = new SpelExpressionParser();
        Expression expr = parser.parseExpression(safeInput);
        // Even if it reaches a SpEL evaluation sink, constant source is safe.
        Object result = expr.getValue();
        System.out.println(result);
    }
}