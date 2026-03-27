// Reference equality comparison where left operand is not a boxed numeric type should not be flagged as suspicious.
package scensct.var.neg;

public class NegCase1_Var2 {
    // Variant 2: Inter-procedural extraction - move each comparison into a separate helper method
    public static void main(String[] args) {
        checkPrimitive();
        checkString();
        checkBoolean();
        checkObject();
    }

    private static void checkPrimitive() {
        int x = 5, y = 5;
        boolean result = (x == y); // primitive
    }

    private static void checkString() {
        String a = new String("hello");
        String b = a;
        boolean result = (a == b); // String ref
    }

    private static void checkBoolean() {
        Boolean b1 = true;
        Boolean b2 = Boolean.TRUE;
        boolean result = (b1 == b2); // Boolean
    }

    private static void checkObject() {
        Object o1 = new Object();
        Object o2 = new Object();
        boolean result = (o1 == o2); // custom object
    }
}