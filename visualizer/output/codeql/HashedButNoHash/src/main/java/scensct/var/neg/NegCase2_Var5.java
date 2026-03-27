// A class with both equals and hashCode whose instance is stored in a hashing data structure should not be flagged as a violation.
package scensct.var.neg;

import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

public class NegCase2_Var5 {
    // Control‑flow variation: instance created and used inside a loop with condition
    static class Box {
        private final int x, y;
        Box(int x, int y) { this.x = x; this.y = y; }
        
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Box)) return false;
            Box b = (Box) o;
            return x == b.x && y == b.y;
        }
        
        @Override
        public int hashCode() {
            return 31 * x + y;
        }
    }

    public static void main(String[] args) {
        HashSet<Box> boxes = new HashSet<>();
        Box target = null;
        for (int i = 0; i < 3; i++) {
            Box b = new Box(i, i * 2);
            boxes.add(b);
            if (i == 1) target = b;
        }
        // Ensure the hashing structure is used with the class instance
        if (target != null) {
            System.out.println(boxes.contains(target));
        }
    }
}