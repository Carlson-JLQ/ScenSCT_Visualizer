// A try statement where a supertype catch precedes a subtype catch, and there exists an exception type that can be thrown from the try block that is not a subtype of the masked (subtype) type should not be flagged as unreachable catch.
package scensct.var.neg;

public class NegCase2_Var3 {
    public static void main(String[] args) {
        // Variant 3: Introducing a temporary variable and more complex condition
        boolean flag = args.length > 0;
        try {
            if (flag) {
                Exception ex = new Exception();
                throw ex;
            } else {
                java.io.IOException ioEx = new java.io.IOException();
                throw ioEx;
            }
        } catch (java.io.IOException e) {
            System.out.println("IOException caught");
        } catch (Exception e) {
            System.out.println("Exception caught");
        }
    }
}