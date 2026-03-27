// A class implements Iterable, declares an iterator() method that returns "this", and any declared method named "hasNext" has a method body that does not contain exactly one statement should be flagged as lacking a guard against multiple concurrent iterations.
package scensct.var.pos;

import java.util.Iterator;

public class PosCase3_Var5 implements Iterable<Object>, Iterator<Object> { // [REPORTED LINE]
    // Iterator returns self
    public Iterator<Object> iterator() {
        return this;
    }

    // hasNext with switch statement (multiple statements)
    public boolean hasNext() {
        int code = 1;
        switch (code) {
            case 1:
                code = 2;
                break;
            default:
                code = 3;
        }
        return code == 2;
    }

    public Object next() {
        throw new UnsupportedOperationException();
    }
}