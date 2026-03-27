// User-controlled string from HttpServletRequest flows into SpelExpressionParser.parseExpression and getValue without secure EvaluationContext should be flagged as SpEL injection.
package scensct.var.pos;

import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class PosCase1_Var3 {
    // Variant 3: Use Optional and method chaining, but still unsafe
    public void evaluateUserInput(HttpServletRequest request) {
        Optional.ofNullable(request.getParameter("input"))
                .map(input -> {
                    SpelExpressionParser parser = new SpelExpressionParser();
                    Expression expr = parser.parseExpression(input);
                    return expr.getValue(); // [REPORTED LINE]
                })
                .ifPresent(System.out::println);
    }
}