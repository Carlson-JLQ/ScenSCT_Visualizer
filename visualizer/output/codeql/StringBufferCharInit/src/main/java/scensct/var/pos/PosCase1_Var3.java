// Passing a char literal to StringBuffer constructor should be flagged as using capacity instead of character.
package scensct.var.pos;

public class PosCase1_Var3 {
    // Variant 3: Extract the call to a helper method
    private static StringBuffer createBuffer(char c) {
        return new StringBuffer(c); // [REPORTED LINE]
    }
    
    public static void main(String[] args) {
        StringBuffer buffer = createBuffer('a');
    }
}