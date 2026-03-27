// Calling remove with compatible argument type should not be flagged as incompatible.
package scensct.core.neg;

import java.util.ArrayList;
import java.util.Collection;

public class NegCase3 {
    public static void main(String[] args) {
        Collection<String> col = new ArrayList<>();
        // Scenario 3: String argument compatible with Collection<String>.
        col.remove("test");
    }
}