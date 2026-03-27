// Calling a method named contains on a non-collection type should not be flagged.
package scensct.var.neg;

import java.util.function.Predicate;

public class NegCase3_Var3 {
    static class CustomContainer {
        public boolean contains(Object obj) {
            return false;
        }
        
        public Predicate<Object> asPredicate() {
            return this::contains;
        }
    }
    
    public static void main(String[] args) {
        CustomContainer container = new CustomContainer();
        Predicate<Object> p = container.asPredicate();
        boolean result = p.test("test");
        System.out.println(result);
    }
}