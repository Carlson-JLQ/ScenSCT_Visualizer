// A class implements Iterable, declares an iterator() method that returns "this", and any declared method named "hasNext" has a body with exactly one statement, which is not a return statement returning the boolean literal false should be flagged as lacking a guard against multiple concurrent iterations.
package scensct.core.pos;

import java.util.Iterator;

public class PosCase4 implements Iterable<Object>, Iterator<Object> { // [REPORTED LINE]
    // Implements Iterable and returns "this" as the iterator
    public Iterator<Object> iterator() {
        return this;
    }

    // hasNext body has exactly one statement, but it returns true (not false)
    public boolean hasNext() {
        return true;
    }

    public Object next() {
        return null;
    }
}