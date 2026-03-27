// A member named "writeObject" defined in a separate non-record class should not be flagged as a direct member of the record.
package scensct.var.neg;

public class NegCase2_Var2 {
    // Record with no special serialization-named members
    record Container<T>(T item) {}

    // Separate non-record class with a special serialization method
    static class ExternalClass {
        private void writeObject(java.io.ObjectOutputStream stream) throws java.io.IOException {
            try {
                stream.defaultWriteObject();
            } finally {
                // cleanup placeholder
            }
        }
    }

    public static void main(String[] args) {
        Container<String> c = new Container<>("test");
        ExternalClass e = new ExternalClass();
        System.out.println(c.item());
    }
}