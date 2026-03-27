// A concrete class that implements Iterable and has an iterator() method returning null should not be flagged.
package scensct.var.neg;

import java.util.Iterator;

public class NegCase5_Var4 implements Iterable<String> {
    private boolean flag = true;

    // Variant 4: Use a loop that breaks immediately, returning null.
    public Iterator<String> iterator() {
        while (flag) {
            break;
        }
        return null;
    }
}