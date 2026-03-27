// A class with equals but no hashCode whose instance is never stored in a hashing data structure should not be flagged as a violation.
package scensct.var.neg;

import java.util.HashSet;
import java.util.Map;

public class NegCase1_Var4 {
    static class Pair {
        private int key;
        Pair(int k) { key = k; }
        
        @Override
        public boolean equals(Object other) {
            if (other == this) return true;
            if (other == null || other.getClass() != Pair.class) return false;
            Pair p = (Pair) other;
            return key == p.key;
        }
        // No hashCode
    }

    public static void main(String[] args) {
        Pair p = new Pair(42);
        // Aliasing and control flow
        Pair q = p;
        for (int i = 0; i < 1; i++) {
            q = new Pair(42);
        }
        if (p.equals(q)) {
            System.out.println("Equal");
        } else {
            System.out.println("Not equal");
        }
        // Still no hashing data structure usage
    }
}