// A member named "writeObject" defined in a separate non-record class should not be flagged as a direct member of the record.
package scensct.var.neg;

public class NegCase2_Var1 {
    // Record with no special serialization-named members
    record DataRecord(String value) {}

    // Separate non-record class containing a member with a special serialization name
    static class SerializationHelper {
        // This method has a special serialization name but is not a direct member of the record
        private void writeObject(java.io.ObjectOutputStream oos) throws java.io.IOException {
            if (oos != null) {
                oos.defaultWriteObject();
            }
        }
    }

    public static void main(String[] args) {
        DataRecord dr = new DataRecord("value");
        SerializationHelper helper = new SerializationHelper();
        System.out.println(dr.value());
    }
}