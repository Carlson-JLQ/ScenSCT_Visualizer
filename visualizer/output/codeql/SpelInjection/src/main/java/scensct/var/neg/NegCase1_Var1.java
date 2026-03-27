// Constant string source should not be flagged as SpEL injection threat.
package scensct.var.neg;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class NegCase1_Var1 {
    public static void main(String[] args) {
        // Variant 1: Constant composed via concatenation
        final String part1 = "1 + ";
        final String part2 = "2";
        String safeInput = part1 + part2;
        ExpressionParser parser = new SpelExpressionParser();
        Expression expr = parser.parseExpression(safeInput);
        Object result = expr.getValue();
        System.out.println(result);
    }
}