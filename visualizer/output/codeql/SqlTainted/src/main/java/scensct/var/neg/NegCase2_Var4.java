// User data flowing to non-SQL sink should not be flagged as SQL injection.
package scensct.var.neg;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.ArrayList;

public class NegCase2_Var4 {
    // Variant 4: Store user input in a collection, then retrieve and output.
    public void doGet(HttpServletRequest request) {
        List<String> inputs = new ArrayList<>();
        inputs.add(request.getParameter("input"));
        String firstInput = inputs.get(0);
        // Output via a StringBuilder (still non-SQL).
        StringBuilder sb = new StringBuilder();
        sb.append("Input: ").append(firstInput);
        System.out.println(sb.toString());
    }
}