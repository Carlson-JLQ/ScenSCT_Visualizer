// A class with both equals and hashCode whose instance is stored in a hashing data structure should not be flagged as a violation.
package scensct.var.neg;

import java.util.HashMap;

public class NegCase2_Var2 {
    // Using HashMap instead of HashSet, class is non-static
    class Entity {
        private long code;
        Entity(long c) { code = c; }
        
        @Override
        public boolean equals(Object o) {
            if (o instanceof Entity) {
                return this.code == ((Entity) o).code;
            }
            return false;
        }
        
        @Override
        public int hashCode() {
            return (int) (code ^ (code >>> 32));
        }
    }

    public static void main(String[] args) {
        NegCase2_Var2 outer = new NegCase2_Var2();
        Entity e = outer.new Entity(100L);
        HashMap<Entity, String> map = new HashMap<>();
        map.put(e, "value");
        System.out.println(map.containsKey(e));
    }
}