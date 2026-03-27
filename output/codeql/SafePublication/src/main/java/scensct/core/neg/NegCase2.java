// A class annotated with @ThreadSafe, but the field in question is declared in a different class (e.g., a field from a superclass or a separate class) should not be flagged as unsafe publication.
package scensct.core.neg;

@ThreadSafe
public class NegCase2 extends SuperClassWithField {
    // The field 'inheritedField' is declared in the superclass, not in this @ThreadSafe class.
}

class SuperClassWithField {
    private Object inheritedField; // Field is in a different class.
}