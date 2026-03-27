// Reference equality comparison where left operand is not a boxed numeric type should not be flagged as suspicious.
package scensct.core.neg;

public class NegCase1 {
    public static void main(String[] args) {
        // Scenario 1: left operand is primitive int
        int a = 5;
        int b = 5;
        boolean comp1 = (a == b); // primitive comparison, not boxed

        // left operand is String
        String s1 = "hello";
        String s2 = "hello";
        boolean comp2 = (s1 == s2); // String reference comparison, not boxed numeric

        // left operand is Boolean
        Boolean bool1 = Boolean.TRUE;
        Boolean bool2 = Boolean.TRUE;
        boolean comp3 = (bool1 == bool2); // Boolean comparison, excluded by checker

        // left operand is custom object
        Object obj1 = new Object();
        Object obj2 = new Object();
        boolean comp4 = (obj1 == obj2); // custom object comparison, not boxed numeric
    }
}