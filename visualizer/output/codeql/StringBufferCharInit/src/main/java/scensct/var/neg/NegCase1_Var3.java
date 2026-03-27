// A constructor call for StringBuffer or StringBuilder where the first argument is not of type char should not be flagged as misinterpreted character capacity.
package scensct.var.neg;

public class NegCase1_Var3 {
    // Variant 3: Wrapper with var and Integer
    public static void main(String[] args) {
        Integer boxedCapacity = Integer.valueOf(100);
        var sb1 = new StringBuilder(boxedCapacity);
        
        var sb2 = new StringBuffer(String.valueOf("initial"));
        
        var sb3 = new StringBuilder();
    }
}