// Constant string source should not be flagged as SpEL injection threat.
package scensct.var.neg;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class NegCase1_Var5 {
    public static void main(String[] args) {
        // Variant 5: Constant via switch expression (Java 14+ style)
        String safeInput = switch (args.length) {
            case 0 -> "1 + 2";
            default -> "1 + 2";
        };
        ExpressionParser parser = new SpelExpressionParser();
        Expression expr = parser.parseExpression(safeInput);
        Object result = expr.getValue();
        System.out.println(result);
    }
}