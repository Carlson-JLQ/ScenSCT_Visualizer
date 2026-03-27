// A class annotated with @ThreadSafe contains a field that is only ever assigned its type's default value either in its declaration or within the class's constructors should not be flagged as unsafe publication.
package scensct.core.neg;

@ThreadSafe
public class NegCase4 {
    private int defaultInt; // Default value 0, no other assignment.
    private Object defaultRef; // Default value null, assigned only in constructor.

    public NegCase4() {
        defaultRef = null; // Explicitly assigned default value in constructor.
    }
}