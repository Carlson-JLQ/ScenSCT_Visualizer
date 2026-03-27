// A local container variable never assigned, never returned, and used only with non-query methods should not be flagged as an uninitialized container.
package scensct.var.neg;

import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

public class NegCase9_Var4 {
    public void test() {
        // Variant 4: Idiomatic variation with List interface and different mutating method
        List<String> otherList = new ArrayList<>();
        List<String> local = otherList; // alias with List type
        local.addAll(List.of("a", "b")); // bulk mutating method
    }
}