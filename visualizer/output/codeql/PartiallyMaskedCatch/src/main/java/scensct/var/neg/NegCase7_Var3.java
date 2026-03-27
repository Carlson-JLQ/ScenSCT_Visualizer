// A try statement where the catch clause at index first catches exception type masking, but the catch clause at index second does not catch exception type masked should not be flagged as unreachable catch.
package scensct.var.neg;

public class NegCase7_Var3 {
    // Variant 3: Inter-procedural - extract throwing logic to a helper
    private static void throwBasedOnArgs(String[] args) throws Exception, java.io.IOException {
        if (args.length > 0) {
            throw new Exception();
        }
        throw new java.io.IOException();
    }

    public static void main(String[] args) {
        try {
            throwBasedOnArgs(args);
        } catch (java.sql.SQLException e) {
            System.out.println("SQLException caught");
        } catch (Exception e) {
            System.out.println("Exception caught");
        }
    }
}