// A method call where the called method is not a recognized format method should not be flagged.
package scensct.var.neg;

public class NegCase2_Var3 {
    // Variant 3: Inter-procedural refactoring - helper method
    private static void outputMessage(String msg) {
        System.out.println(msg);
    }
    
    public static void main(String[] args) {
        outputMessage("Hello");
    }
}