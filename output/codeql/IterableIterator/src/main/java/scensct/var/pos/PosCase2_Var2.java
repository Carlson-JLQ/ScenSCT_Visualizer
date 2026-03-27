// A class implements Iterable, declares an iterator() method that returns "this", and any declared method named "hasNext" has no method body should be flagged as lacking a guard against multiple concurrent iterations.
package scensct.var.pos;

import java.util.Iterator;

public abstract class PosCase2_Var2 implements Iterable<Object>, Iterator<Object> {
    
    private Iterator<Object> getSelfAsIterator() {
        return this;
    }
    
    public Iterator<Object> iterator() {
        return getSelfAsIterator(); // delegates to a helper, still returns this
    }

    public abstract boolean hasNext();
}