// A class implements Iterable, declares an iterator() method that returns "this", and any declared method named "hasNext" has a body with exactly one statement, which is not a return statement returning the boolean literal false should be flagged as lacking a guard against multiple concurrent iterations.
package scensct.var.pos;

import java.util.Iterator;

public class PosCase4_Var2 implements Iterable<Object>, Iterator<Object> {
    // Keep iterator returning this
    public Iterator<Object> iterator() {
        Iterator<Object> it = this;
        return it;
    }

    // hasNext with a try-catch that doesn't affect the single return statement
    public boolean hasNext() {
        try {
            return 1 < 2;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // next with a dummy operation
    public Object next() {
        System.gc();
        return null;
    }
}