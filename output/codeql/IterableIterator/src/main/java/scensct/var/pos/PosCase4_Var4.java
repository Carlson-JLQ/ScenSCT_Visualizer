// A class implements Iterable, declares an iterator() method that returns "this", and any declared method named "hasNext" has a body with exactly one statement, which is not a return statement returning the boolean literal false should be flagged as lacking a guard against multiple concurrent iterations.
package scensct.var.pos;

import java.util.Iterator;

public class PosCase4_Var4 implements Iterable<Object>, Iterator<Object> {
    // iterator returns this via a ternary operator (trivial)
    public Iterator<Object> iterator() {
        return (System.currentTimeMillis() > 0) ? this : this;
    }

    // hasNext with a single statement that is not a simple return false
    public boolean hasNext() {
        for (int i = 0; i < 1; i++) {
            return i == 0;
        }
        return false; // This line is unreachable, but the method body still has one reachable return
    }

    public Object next() {
        return Integer.valueOf(42);
    }
}