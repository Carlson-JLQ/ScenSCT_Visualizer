// A class without the @ThreadSafe annotation contains a non-final, non-static, non-volatile field of a non-thread-safe type, not initialized to a default value should not be flagged as unsafe publication.
package scensct.var.neg;

public class NegCase1_Var5 {
    // Field wrapped in a non-thread-safe holder class, still unannotated.
    private static class Holder {
        Object content;
    }

    private Holder fieldHolder = new Holder();
}