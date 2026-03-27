// A member named "writeObject" defined in a separate non-record class should not be flagged as a direct member of the record.
package scensct.core.neg;

public class NegCase2 {
    // Record with no special serialization-named members
    record MyRecord(String data) {}

    // Separate non-record class containing a member with a special serialization name
    static class SeparateClass {
        // This method has a special serialization name but is not a direct member of the record
        private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
            out.defaultWriteObject();
        }
    }

    public static void main(String[] args) {
        MyRecord r = new MyRecord("data");
        SeparateClass s = new SeparateClass();
        System.out.println(r.data());
    }
}