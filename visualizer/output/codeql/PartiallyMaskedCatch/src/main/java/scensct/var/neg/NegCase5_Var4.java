// A try statement where a supertype catch precedes a subtype catch, the subtype is a RuntimeException or Error, and no prior catch clause catches a supertype of any exception that could be thrown and is a subtype of the masked type should not be flagged as unreachable catch.
package scensct.var.neg;

public class NegCase5_Var4 {
    public static void main(String[] args) {
        try {
            // Use a try-with-resources that doesn't throw, but then throw Error
            try (java.io.StringReader reader = new java.io.StringReader("test")) {
                // No exception from resource
            }
            throw new VirtualMachineError("Simulated VM error") {};
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught");
        } catch (Exception e) {
            System.out.println("Exception caught");
        }
    }
}