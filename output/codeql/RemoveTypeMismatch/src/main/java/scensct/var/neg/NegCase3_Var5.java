// Calling remove with compatible argument type should not be flagged as incompatible.
package scensct.var.neg;

import java.util.ArrayList;
import java.util.Collection;

public class NegCase3_Var5 {
    public static void main(String[] args) {
        // Variant 5: Aliasing and nested try-finally to obscure flow.
        Collection<String> col = new ArrayList<>();
        Collection<String> alias = col;
        try {
            alias.remove("test");
        } finally {
            // Cleanup or other operations, but removal already happened.
            alias.clear(); // Irrelevant to the scenario.
        }
    }
}