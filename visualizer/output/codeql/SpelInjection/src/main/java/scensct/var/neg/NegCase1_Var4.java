// Constant string source should not be flagged as SpEL injection threat.
package scensct.var.neg;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class NegCase1_Var4 {
    // Variant 4: Helper method returning constant
    private static String getSafeExpression() {
        return "1 + 2";
    }
    
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        Expression expr = parser.parseExpression(getSafeExpression());
        Object result = expr.getValue();
        System.out.println(result);
    }
}