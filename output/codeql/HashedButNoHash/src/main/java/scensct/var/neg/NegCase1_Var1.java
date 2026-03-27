// A class with equals but no hashCode whose instance is never stored in a hashing data structure should not be flagged as a violation.
package scensct.var.neg;

import java.util.HashSet;
import java.util.Map;

public class NegCase1_Var1 {
    // Renamed class, same structure
    static class Item {
        private final int value;
        Item(int v) { value = v; }
        
        @Override
        public boolean equals(Object other) {
            if (other instanceof Item) {
                return this.value == ((Item) other).value;
            }
            return false;
        }
        // Still no hashCode
    }

    public static void main(String[] args) {
        Item a = new Item(5);
        Item b = new Item(5);
        // Equals check remains, but no hashing usage
        boolean same = a.equals(b);
        System.out.println("Are they equal? " + same);
    }
}