// Flow with extra taint steps present but not connecting source to sink.
package scensct.var.neg;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import javax.servlet.http.HttpServletRequest;

public class NegCase6_Var3 {
    public void indirectFlow(HttpServletRequest request) {
        String userInput = request.getParameter("input");
        // Inter-procedural refactoring: taint step moved to a helper method.
        String intermediate = processInput(userInput);
        ExpressionParser parser = new SpelExpressionParser();
        Expression expr = parser.parseExpression("constant");
        Object result = expr.getValue();
        System.out.println(result);
    }

    private String processInput(String input) {
        // This method processes tainted data but does not affect the sink.
        return input.toUpperCase();
    }
}