// A class implements Iterable, declares an iterator() method that returns "this", and any declared method named "hasNext" has a method body that does not contain exactly one statement should be flagged as lacking a guard against multiple concurrent iterations.
package scensct.var.pos;

import java.util.Iterator;

public class PosCase3_Var1 implements Iterable<Object>, Iterator<Object> { // [REPORTED LINE]
    // Return self as iterator
    public Iterator<Object> iterator() {
        return this;
    }

    // hasNext with multiple statements via if-else
    public boolean hasNext() {
        boolean result = false;
        if (System.currentTimeMillis() > 0) {
            result = false;
        } else {
            result = true;
        }
        return result;
    }

    public Object next() {
        return new Object();
    }
}