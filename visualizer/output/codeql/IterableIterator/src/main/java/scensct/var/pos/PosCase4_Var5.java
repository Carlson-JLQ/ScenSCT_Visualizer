// A class implements Iterable, declares an iterator() method that returns "this", and any declared method named "hasNext" has a body with exactly one statement, which is not a return statement returning the boolean literal false should be flagged as lacking a guard against multiple concurrent iterations.
package scensct.var.pos;

import java.util.Iterator;

public class PosCase4_Var5 implements Iterable<Object>, Iterator<Object> { // [REPORTED LINE]
    // iterator returns this directly
    public Iterator<Object> iterator() {
        return this;
    }

    // hasNext with a single statement that includes a side effect but returns true
    public boolean hasNext() {
        return (new Object() != null) && true;
    }

    // next() throws UnsupportedOperationException to simulate an optional operation
    public Object next() {
        throw new UnsupportedOperationException("not implemented");
    }
}