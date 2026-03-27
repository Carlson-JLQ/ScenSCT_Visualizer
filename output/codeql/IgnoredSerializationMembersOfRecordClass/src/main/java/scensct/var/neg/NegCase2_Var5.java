// A member named "writeObject" defined in a separate non-record class should not be flagged as a direct member of the record.
package scensct.var.neg;

public class NegCase2_Var5 {
    // Record with no special serialization-named members
    record Pair<A, B>(A first, B second) {}

    // Non-record class with nested inner class containing the special method
    static class Outer {
        static class Inner {
            private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
                out.defaultWriteObject();
            }
        }
    }

    public static void main(String[] args) {
        Pair<String, Integer> p = new Pair<>("key", 42);
        Outer.Inner inner = new Outer.Inner();
        System.out.println(p.first());
    }
}