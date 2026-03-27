// A try statement where a supertype catch precedes a subtype catch, the subtype is a RuntimeException or Error, and no prior catch clause catches a supertype of any exception that could be thrown and is a subtype of the masked type should not be flagged as unreachable catch.
package scensct.core.neg;

public class NegCase5 {
    public static void main(String[] args) {
        try {
            // Throw Error, which is not a subtype of Exception
            throw new Error();
        } catch (RuntimeException e) {
            // Catch RuntimeException (subtype of Exception)
            System.out.println("RuntimeException caught");
        } catch (Exception e) {
            // Catch Exception (supertype)
            System.out.println("Exception caught");
        }
    }
}