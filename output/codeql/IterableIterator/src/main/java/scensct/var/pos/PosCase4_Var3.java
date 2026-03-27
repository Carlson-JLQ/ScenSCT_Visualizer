// A class implements Iterable, declares an iterator() method that returns "this", and any declared method named "hasNext" has a body with exactly one statement, which is not a return statement returning the boolean literal false should be flagged as lacking a guard against multiple concurrent iterations.
package scensct.var.pos;

import java.util.Iterator;

public class PosCase4_Var3 implements Iterable<Object>, Iterator<Object> {
    // Inline a helper method call in iterator
    public Iterator<Object> iterator() {
        return getSelf();
    }

    private Iterator<Object> getSelf() {
        return this;
    }

    // hasNext with a single statement that computes true via method call
    public boolean hasNext() {
        return checkHasNext();
    }

    private boolean checkHasNext() {
        return true;
    }

    public Object next() {
        return "dummy";
    }
}