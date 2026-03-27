// A class implements Iterable, declares an iterator() method that returns "this", and any declared method named "hasNext" has a body with exactly one statement, which is not a return statement returning the boolean literal false should be flagged as lacking a guard against multiple concurrent iterations.
package scensct.var.pos;

import java.util.Iterator;

public class PosCase4_Var1 implements Iterable<Object>, Iterator<Object> { // [REPORTED LINE]
    // Rename method parameter? Not applicable. Keep iterator returning this.
    public Iterator<Object> iterator() {
        return this;
    }

    // Change hasNext to use a variable but still return true in one statement
    public boolean hasNext() {
        boolean available = !false;
        return available;
    }

    // next() can be modified slightly
    public Object next() {
        return new Object();
    }
}