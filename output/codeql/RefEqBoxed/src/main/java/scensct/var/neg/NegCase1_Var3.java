// Reference equality comparison where left operand is not a boxed numeric type should not be flagged as suspicious.
package scensct.var.neg;

public class NegCase1_Var3 {
    // Variant 3: Introduce try-catch and expression nesting, with aliasing
    public static void main(String[] args) {
        try {
            int base = 5;
            int derived = base;
            boolean comp1 = ((base) == (derived)); // primitive, nested parentheses
        } catch (Exception e) {
            // ignore
        }

        String first = "hello";
        String second = first;
        boolean comp2 = (first == second); // String ref

        Boolean boolRef = null;
        try {
            boolRef = Boolean.FALSE;
        } finally {
            Boolean anotherBool = boolRef;
            boolean comp3 = (boolRef == anotherBool); // Boolean, possibly null
        }

        Object obj = new Object();
        Object alias = obj;
        boolean comp4 = (obj == alias); // custom object
    }
}