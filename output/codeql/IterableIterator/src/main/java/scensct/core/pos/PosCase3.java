// A class implements Iterable, declares an iterator() method that returns "this", and any declared method named "hasNext" has a method body that does not contain exactly one statement should be flagged as lacking a guard against multiple concurrent iterations.
package scensct.core.pos;

import java.util.Iterator;

public class PosCase3 implements Iterable<Object>, Iterator<Object> { // [REPORTED LINE]
    // Implements Iterable and returns "this" as the iterator
    public Iterator<Object> iterator() {
        return this;
    }

    // hasNext body does not contain exactly one statement
    public boolean hasNext() {
        int dummy = 0;
        return false;
    }

    public Object next() {
        return null;
    }
}