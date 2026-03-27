// A class implements Iterable, declares an iterator() method that returns "this", and any declared method named "hasNext" has no method body should be flagged as lacking a guard against multiple concurrent iterations.
package scensct.var.pos;

import java.util.Iterator;

public abstract class PosCase2_Var5 implements Iterable<Object>, Iterator<Object> {
    
    public Iterator<Object> iterator() {
        class Local {
            Iterator<Object> getIt(PosCase2_Var5 outer) {
                return outer;
            }
        }
        return new Local().getIt(this); // still returns this via a local class
    }

    public abstract boolean hasNext();
}