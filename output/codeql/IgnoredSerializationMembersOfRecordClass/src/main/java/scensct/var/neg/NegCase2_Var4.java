// A member named "writeObject" defined in a separate non-record class should not be flagged as a direct member of the record.
package scensct.var.neg;

public class NegCase2_Var4 {
    // Record with no special serialization-named members
    record LogEntry(String msg, long timestamp) {}

    // Separate non-record class with multiple special serialization names
    static class SerializationContainer {
        private void writeObject(java.io.ObjectOutputStream o) throws java.io.IOException {
            o.defaultWriteObject();
        }
        private Object writeReplace() {
            return null;
        }
    }

    public static void main(String[] args) {
        LogEntry le = new LogEntry("hello", System.currentTimeMillis());
        SerializationContainer sc = new SerializationContainer();
        System.out.println(le.msg());
    }
}