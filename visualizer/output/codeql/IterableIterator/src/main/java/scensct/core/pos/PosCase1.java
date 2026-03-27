// A class implements Iterable, declares an iterator() method that returns "this", and declares no other methods should be flagged as lacking a guard against multiple concurrent iterations.
package scensct.core.pos;

import java.util.Iterator;

public class PosCase1 implements Iterable<Object>, Iterator<Object> {
    // Implements Iterable and returns "this" as the iterator
    public Iterator<Object> iterator() {
        return this;
    }

    public boolean hasNext() {
        return false;
    }

    public Object next() {
        return null;
    }
}