// A try statement with catch clauses where a general checked exception precedes a specific one should be flagged as unreachable.
package scensct.var.pos;

public class PosCase1_Var2 {
    static class TopException extends Exception {}
    static class SubException extends TopException {}

    public static void main(String[] args) {
        // Reorder statements and add dummy code before the try
        int x = 10;
        if (x > 5) {
            try {
                // Throw directly
                throw new SubException();
            } catch (SubException se) {
                // Handle specific
                se.printStackTrace();
            } catch (TopException te) { // [REPORTED LINE]
                // Unreachable
                te.printStackTrace();
            }
        }
    }
}