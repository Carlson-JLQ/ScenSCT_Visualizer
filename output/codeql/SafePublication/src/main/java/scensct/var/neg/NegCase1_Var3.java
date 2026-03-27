// A class without the @ThreadSafe annotation contains a non-final, non-static, non-volatile field of a non-thread-safe type, not initialized to a default value should not be flagged as unsafe publication.
package scensct.var.neg;

public class NegCase1_Var3 {
    private Object unsafeField;

    // Added a constructor that writes the field, but still no @ThreadSafe.
    public NegCase1_Var3(Object value) {
        this.unsafeField = value;
    }

    // A getter without synchronization.
    public Object getUnsafeField() {
        return unsafeField;
    }
}