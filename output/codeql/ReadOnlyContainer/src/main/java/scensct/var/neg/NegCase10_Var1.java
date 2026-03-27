// A local container variable assigned non-fresh source, never returned, and never used as qualifier should not be flagged as an uninitialized container.
package scensct.var.neg;

import java.util.Collection;
import java.util.ArrayList;

public class NegCase10_Var1 {
    public void test() {
        // Variant 1: Lexical refactoring – split declaration and assignment, rename variables
        Collection<String> sourceContainer = new ArrayList<>();
        Collection<String> alias;
        alias = sourceContainer;
        // No further use
    }
}