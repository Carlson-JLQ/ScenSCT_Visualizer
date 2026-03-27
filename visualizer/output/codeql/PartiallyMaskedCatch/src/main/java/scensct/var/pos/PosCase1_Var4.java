// A try statement with catch clauses where a general checked exception precedes a specific one should be flagged as unreachable.
package scensct.var.pos;

public class PosCase1_Var4 {
    static class AException extends Exception {}
    static class BException extends AException {}

    public static void main(String[] args) {
        // Nest the try inside a loop
        for (int i = 0; i < 3; i++) {
            try {
                if (i % 2 == 0) {
                    throw new BException();
                } else {
                    throw new AException();
                }
            } catch (BException be) {
                // Catches BException instances
            } catch (AException ae) {
                // This clause is unreachable for BException, but reachable for AException
                // The checker should still flag it as unreachable for the BException path.
                // The pattern of specific before general remains.
            }
        }
    }
}