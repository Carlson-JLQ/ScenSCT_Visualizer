// A try statement with catch clauses where a general checked exception precedes a specific one should be flagged as unreachable.
package scensct.var.pos;

public class PosCase1_Var1 {
    static class BaseEx extends Exception {}
    static class DerivedEx extends BaseEx {}

    static void throwDerived() throws DerivedEx {
        throw new DerivedEx();
    }

    public static void main(String[] args) {
        // Single try block with the unreachable pattern
        try {
            throwDerived();
        } catch (DerivedEx e) {
            System.out.println("Caught derived");
        } catch (BaseEx e) { // [REPORTED LINE]
            // Unreachable catch clause
        }
    }
}