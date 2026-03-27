// A member named "writeObject" defined in a separate non-record class should not be flagged as a direct member of the record.
package scensct.var.neg;

public class NegCase2_Var3 {
    // Record with no special serialization-named members
    record Point(int x, int y) {}

    // Base class containing the special-named method
    static abstract class BaseSerializer {
        abstract void serialize();
        private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
            out.defaultWriteObject();
        }
    }

    // Concrete non-record class inheriting the special method
    static class SerializerImpl extends BaseSerializer {
        void serialize() {}
    }

    public static void main(String[] args) {
        Point p = new Point(1, 2);
        SerializerImpl s = new SerializerImpl();
        System.out.println(p.x() + ", " + p.y());
    }
}