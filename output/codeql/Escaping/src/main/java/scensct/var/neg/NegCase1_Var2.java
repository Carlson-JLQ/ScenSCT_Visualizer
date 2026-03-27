// A class without the @ThreadSafe annotation contains a non-final, non-private, non-volatile field should not be flagged as thread-safe concurrency issue.
package scensct.var.neg;

public class NegCase1_Var2 {
    // Field with a more complex type (mutable object) but still non-final, non-private, non-volatile
    StringBuilder buffer;

    // Static initializer block - no impact on thread-safety annotation
    static {
        System.out.println("Class loaded");
    }

    // Instance initializer setting the field
    {
        buffer = new StringBuilder();
    }

    // Public method that modifies the field without synchronization
    public void append(String s) {
        buffer.append(s);
    }
}