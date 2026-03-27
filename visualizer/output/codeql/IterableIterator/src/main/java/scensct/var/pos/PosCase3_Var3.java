// A class implements Iterable, declares an iterator() method that returns "this", and any declared method named "hasNext" has a method body that does not contain exactly one statement should be flagged as lacking a guard against multiple concurrent iterations.
package scensct.var.pos;

import java.util.Iterator;

public class PosCase3_Var3 implements Iterable<Object>, Iterator<Object> { // [REPORTED LINE]
    // Unchanged iterator method
    public Iterator<Object> iterator() {
        return this;
    }

    // hasNext with try-catch block (multiple statements)
    public boolean hasNext() {
        try {
            String s = "test";
            s.length();
        } catch (Exception e) {
            // ignore
        }
        return false;
    }

    public Object next() {
        return Integer.valueOf(42);
    }
}