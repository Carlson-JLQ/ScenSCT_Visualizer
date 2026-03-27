// If condition inside loop with constant false comparison and increment compared to itself, then branch not a throw.
package scensct.var.pos;

public class PosCase4_Var5 {
    public static void main(String[] args) {
        // Variant 5: nested loops, try-catch, same false comparison
        int val = 0;
        outer: for (int t = 0; t < 5; t++) {
            while (val < 10) {
                try {
                    int dec = --val;
                    if (dec > val) { // dec = val-1, val = val after decrement? Wait: --val returns new val, so dec = new val, val = new val. // [REPORTED LINE]
                        // Actually: int dec = --val; means val = val-1, dec = val (new).
                        // Then dec > val? dec == val, so false.
                        System.out.println("Unreachable");
                    }
                } finally {
                    // ensure loop progresses
                }
                val += 2;
                if (val > 20) break outer; // [REPORTED LINE]
            }
        }
    }
}