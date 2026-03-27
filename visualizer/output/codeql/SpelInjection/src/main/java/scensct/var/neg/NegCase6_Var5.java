// Flow with extra taint steps present but not connecting source to sink.
package scensct.var.neg;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import javax.servlet.http.HttpServletRequest;

public class NegCase6_Var5 {
    public void indirectFlow(HttpServletRequest request) {
        String userInput = request.getParameter("input");
        // Aliasing and try-catch: tainted data is aliased but not used in sink.
        String intermediate = userInput.toUpperCase();
        String alias = intermediate;
        ExpressionParser parser = new SpelExpressionParser();
        try {
            Expression expr = parser.parseExpression("constant");
            Object result = expr.getValue();
            System.out.println(result);
        } catch (Exception e) {
            // Exception handling that does not involve tainted data.
            System.err.println("Evaluation failed");
        }
    }
}