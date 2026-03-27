// Independent threat source and SpEL sink should not be flagged as injection.
package scensct.core.neg;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import javax.servlet.http.HttpServletRequest;

public class NegCase2 {
    public void process(HttpServletRequest request) {
        // Recognized threat source exists.
        String userInput = request.getParameter("input");
        // Independent SpEL evaluation with safe constant.
        ExpressionParser parser = new SpelExpressionParser();
        Expression expr = parser.parseExpression("'safe'");
        Object result = expr.getValue();
        System.out.println(result);
        // No data flow from userInput to expr evaluation.
    }
}