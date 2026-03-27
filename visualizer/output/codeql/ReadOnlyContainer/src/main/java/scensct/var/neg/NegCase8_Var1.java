// A private container field assigned non-fresh source and used with mutating methods should not be flagged as an uninitialized container.
package scensct.var.neg;

import java.util.Collection;
import java.util.ArrayList;

public class NegCase8_Var1 {
    private Collection<String> field;
    
    public void test() {
        // Lexical refactoring: swap assignment order and use a temporary variable
        Collection<String> temp = null;
        field = temp;
        
        // Non-fresh source via method return (still non-fresh)
        Collection<String> other = getEmptyList();
        field = other;
        
        // Mutating method with a different signature (add with index simulation not available, so use clear then add)
        field.clear();
        field.add("item");
    }
    
    private ArrayList<String> getEmptyList() {
        return new ArrayList<>();
    }
}