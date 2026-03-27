// A try statement with catch clauses where a general checked exception precedes a specific one should be flagged as unreachable.
package scensct.var.pos;

public class PosCase1_Var3 {
    static class General extends Exception {}
    static class Specific extends General {}

    static void mightThrow() throws Specific {
        throw new Specific();
    }

    static void handleSpecific(Specific s) {
        // dummy handler
    }

    static void handleGeneral(General g) {
        // dummy handler
    }

    public static void main(String[] args) {
        // Extract catch block logic to methods
        try {
            mightThrow();
        } catch (Specific s) {
            handleSpecific(s);
        } catch (General g) { // [REPORTED LINE]
            handleGeneral(g);
        }
    }
}