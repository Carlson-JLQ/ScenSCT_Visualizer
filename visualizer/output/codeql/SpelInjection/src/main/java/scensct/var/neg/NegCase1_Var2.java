// Constant string source should not be flagged as SpEL injection threat.
package scensct.var.neg;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class NegCase1_Var2 {
    // Variant 2: Constant defined as static final field
    private static final String SAFE_EXPR = "1 + 2";
    
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        Expression expr = parser.parseExpression(SAFE_EXPR);
        Object result = expr.getValue();
        System.out.println(result);
    }
}