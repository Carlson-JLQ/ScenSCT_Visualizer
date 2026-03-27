// Constant string source should not be flagged as SpEL injection threat.
package scensct.var.neg;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class NegCase1_Var3 {
    public static void main(String[] args) {
        // Variant 3: Control flow with constant assignment
        String safeInput;
        if (System.currentTimeMillis() > 0) { // always true
            safeInput = "1 + 2";
        } else {
            safeInput = "3 * 4";
        }
        ExpressionParser parser = new SpelExpressionParser();
        Expression expr = parser.parseExpression(safeInput);
        Object result = expr.getValue();
        System.out.println(result);
    }
}