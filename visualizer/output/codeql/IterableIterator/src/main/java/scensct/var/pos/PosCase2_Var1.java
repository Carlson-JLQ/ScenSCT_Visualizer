// A class implements Iterable, declares an iterator() method that returns "this", and any declared method named "hasNext" has no method body should be flagged as lacking a guard against multiple concurrent iterations.
package scensct.var.pos;

import java.util.Iterator;

public abstract class PosCase2_Var1 implements Iterator<Object>, Iterable<Object> {
    // swapped interface order
    
    @Override
    public Iterator<Object> iterator() {
        PosCase2_Var1 self = this;
        return self; // still returns this, but via a local variable
    }

    public abstract boolean hasNext();
}