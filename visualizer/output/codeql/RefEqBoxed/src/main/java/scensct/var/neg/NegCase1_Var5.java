// Reference equality comparison where left operand is not a boxed numeric type should not be flagged as suspicious.
package scensct.var.neg;

public class NegCase1_Var5 {
    // Variant 5: Idiomatic variations with enums, null checks, and method returns
    enum Status { ACTIVE }
    
    public static void main(String[] args) {
        // primitive via method return
        boolean comp1 = (getInt() == getInt()); // primitive
        
        // String via static field
        boolean comp2 = (CONST_STRING == CONST_STRING); // String ref
        
        // Boolean via ternary
        Boolean b = args.length > 0 ? Boolean.TRUE : Boolean.FALSE;
        boolean comp3 = (b == Boolean.TRUE); // Boolean
        
        // custom object via enum
        Status s1 = Status.ACTIVE;
        Status s2 = Status.ACTIVE;
        boolean comp4 = (s1 == s2); // enum, not boxed numeric
    }
    
    private static final String CONST_STRING = "hello";
    private static int getInt() { return 5; }
}