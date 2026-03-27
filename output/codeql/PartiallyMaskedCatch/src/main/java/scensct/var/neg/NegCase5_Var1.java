// A try statement where a supertype catch precedes a subtype catch, the subtype is a RuntimeException or Error, and no prior catch clause catches a supertype of any exception that could be thrown and is a subtype of the masked type should not be flagged as unreachable catch.
package scensct.var.neg;

public class NegCase5_Var1 {
    public static void main(String[] args) {
        try {
            // Throw a different Error subtype
            throw new OutOfMemoryError("Memory exhausted");
        } catch (RuntimeException re) {
            System.out.println("RuntimeException caught");
        } catch (Exception ex) {
            System.out.println("Exception caught");
        }
    }
}