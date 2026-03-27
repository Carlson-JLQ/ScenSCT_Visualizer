// Flow with extra taint steps present but not connecting source to sink.
package scensct.var.neg;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import javax.servlet.http.HttpServletRequest;

public class NegCase6_Var2 {
    public void indirectFlow(HttpServletRequest request) {
        String userInput = request.getParameter("input");
        // Intra-procedural refactoring: tainted data flows into a dead branch.
        String intermediate = userInput.toUpperCase();
        ExpressionParser parser = new SpelExpressionParser();
        Expression expr;
        if (intermediate.length() > 1000) { // Impossible condition
            expr = parser.parseExpression(intermediate); // Dead code, never executed
        } else {
            expr = parser.parseExpression("constant"); // Safe constant used
        }
        Object result = expr.getValue(); // [REPORTED LINE]
        System.out.println(result);
    }
}