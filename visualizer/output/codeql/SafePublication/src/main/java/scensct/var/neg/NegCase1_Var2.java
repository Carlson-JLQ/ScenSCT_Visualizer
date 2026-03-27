// A class without the @ThreadSafe annotation contains a non-final, non-static, non-volatile field of a non-thread-safe type, not initialized to a default value should not be flagged as unsafe publication.
package scensct.var.neg;

import java.util.ArrayList;

public class NegCase1_Var2 {
    // Changed to another non-thread-safe type, still unannotated.
    private ArrayList<String> unsafeList;
}