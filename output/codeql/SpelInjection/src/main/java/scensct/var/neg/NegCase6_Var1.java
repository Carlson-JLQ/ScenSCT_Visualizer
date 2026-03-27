// Flow with extra taint steps present but not connecting source to sink.
package scensct.var.neg;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import javax.servlet.http.HttpServletRequest;

public class NegCase6_Var1 {
    public void indirectFlow(HttpServletRequest request) {
        String userInput = request.getParameter("input");
        // Taint step with a method call that does not propagate to sink.
        String intermediate = userInput.toUpperCase();
        // Lexical refactoring: constant built via concatenation, still safe.
        String safeConstant = "con" + "stant";
        ExpressionParser parser = new SpelExpressionParser();
        Expression expr = parser.parseExpression(safeConstant);
        Object result = expr.getValue();
        System.out.println(result);
        // Tainted intermediate is never used in the sink.
    }
}