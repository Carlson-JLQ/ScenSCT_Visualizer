// A try statement where the catch clause at index first catches exception type masking, but the catch clause at index second does not catch exception type masked should not be flagged as unreachable catch.
package scensct.var.neg;

public class NegCase7_Var4 {
    // Variant 4: Idiomatic variation - use different exception types from java.sql
    // but maintain same subtype relationship: SQLWarning is also a subtype of Exception
    public static void main(String[] args) {
        try {
            if (args.length > 0) {
                throw new java.io.FileNotFoundException(); // Still a subclass of IOException, which is Exception
            } else {
                throw new Exception();
            }
        } catch (java.sql.SQLWarning e) { // First catch: SQLWarning (subtype of Exception)
            System.out.println("SQLWarning caught");
        } catch (Exception e) { // Second catch: Exception (supertype)
            System.out.println("Exception caught");
        }
    }
}