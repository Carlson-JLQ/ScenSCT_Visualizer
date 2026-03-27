// A class implements Iterable, declares an iterator() method that returns "this", and any declared method named "hasNext" has a method body that does not contain exactly one statement should be flagged as lacking a guard against multiple concurrent iterations.
package scensct.ref.pos;

import java.util.Iterator;

public class PosCase3_FN1 implements Iterable<Object>, Iterator<Object> {
    // Implements Iterable and returns "this" as the iterator
    public Iterator<Object> iterator() {
        return this;
    }

    // hasNext body is an empty block (zero statements), not exactly one statement
    public boolean hasNext() {
        // Empty block
        return false;
    }

    public Object next() {
        return null;
    }
}