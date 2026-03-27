// Reference equality comparison where left operand is boxed numeric and right operand is not a boxed numeric type should not be flagged as suspicious.
package scensct.var.neg;

public class NegCase2_Var6 {
    public static void main(String[] args) {
        Long leftLong = Long.valueOf(10L);
        int primitive = Integer.parseInt("10");
        boolean comp1 = primitive == leftLong;          // primitive on left
        
        Short leftShort = Short.valueOf((short) 10);
        String str = String.valueOf(10);
        boolean comp2 = str.equals("") ? false : leftShort == (Object) str;
        
        Boolean boolObj = Boolean.FALSE;
        boolean comp3 = boolObj == (Object) leftLong;   // Boolean on left
        
        Object n = null;
        boolean comp4 = n == leftShort;                 // null on left
    }
}