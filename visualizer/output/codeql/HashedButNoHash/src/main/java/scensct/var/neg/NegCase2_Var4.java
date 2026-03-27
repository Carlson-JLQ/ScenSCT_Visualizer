// A class with both equals and hashCode whose instance is stored in a hashing data structure should not be flagged as a violation.
package scensct.var.neg;

import java.util.LinkedHashSet;

public class NegCase2_Var4 {
    // equals/hashCode defined in a superclass, subclass used in LinkedHashSet
    static abstract class Base {
        protected int key;
        Base(int k) { key = k; }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Base base = (Base) o;
            return key == base.key;
        }
        
        @Override
        public int hashCode() {
            return key;
        }
    }
    
    static class Derived extends Base {
        Derived(int k) { super(k); }
    }

    public static void main(String[] args) {
        Derived d = new Derived(9);
        LinkedHashSet<Base> set = new LinkedHashSet<>();
        set.add(d);
        System.out.println(set.size());
    }
}