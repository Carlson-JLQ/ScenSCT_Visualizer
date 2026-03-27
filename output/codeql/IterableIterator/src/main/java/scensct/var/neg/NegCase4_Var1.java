// A concrete class that implements Iterable and has an iterator() method with empty body should not be flagged.
package scensct.var.neg;

import java.util.Iterator;

public class NegCase4_Var1 implements Iterable<Object> {
    // Variant 1: Lexical refactoring with a local variable.
    public Iterator<Object> iterator() {
        Iterator<Object> it = null;
        return it;
    }
}