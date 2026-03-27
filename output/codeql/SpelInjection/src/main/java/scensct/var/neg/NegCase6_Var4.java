// Flow with extra taint steps present but not connecting source to sink.
package scensct.var.neg;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import javax.servlet.http.HttpServletRequest;

public class NegCase6_Var4 {
    public void indirectFlow(HttpServletRequest request) {
        String userInput = request.getParameter("input");
        // Control-flow restructuring: loop that manipulates tainted data but sink is outside.
        String intermediate = userInput.toUpperCase();
        for (int i = 0; i < intermediate.length(); i++) {
            // Perform some operation that doesn't affect the sink.
            char c = intermediate.charAt(i);
        }
        ExpressionParser parser = new SpelExpressionParser();
        Expression expr = parser.parseExpression("constant");
        Object result = expr.getValue();
        System.out.println(result);
    }
}