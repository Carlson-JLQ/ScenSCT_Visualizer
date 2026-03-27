// A try statement with catch clauses where a general checked exception precedes a specific one should be flagged as unreachable.
package scensct.var.pos;

public class PosCase1_Var5 {
    static class ParentEx extends Exception {}
    static class ChildEx extends ParentEx {}

    public static void main(String[] args) throws ChildEx {
        // Use a try-with-resources to add complexity
        try (java.io.StringReader reader = new java.io.StringReader("test")) {
            throw new ChildEx();
        } catch (ChildEx ce) {
            // specific
        } catch (ParentEx pe) { // [REPORTED LINE]
            // unreachable
        }
    }
}