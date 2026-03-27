// A class with equals but no hashCode whose instance is never stored in a hashing data structure should not be flagged as a violation.
package scensct.var.neg;

import java.util.HashSet;
import java.util.Map;

public class NegCase1_Var3 {
    static class Entity {
        private int id;
        Entity(int id) { this.id = id; }
        
        @Override
        public boolean equals(Object o) {
            if (o == null) return false;
            if (o.getClass() != this.getClass()) return false;
            Entity e = (Entity) o;
            return id == e.id;
        }
        // No hashCode
    }
    
    static void compare(Entity x, Entity y) {
        // Helper method that uses equals but no hashing
        System.out.println(x.equals(y));
    }

    public static void main(String[] args) {
        Entity e1 = new Entity(7);
        Entity e2 = new Entity(7);
        compare(e1, e2);
        // No HashSet/HashMap usage anywhere
    }
}