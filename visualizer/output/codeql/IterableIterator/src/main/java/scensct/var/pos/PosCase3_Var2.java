// A class implements Iterable, declares an iterator() method that returns "this", and any declared method named "hasNext" has a method body that does not contain exactly one statement should be flagged as lacking a guard against multiple concurrent iterations.
package scensct.var.pos;

import java.util.Iterator;

public class PosCase3_Var2 implements Iterable<Object>, Iterator<Object> { // [REPORTED LINE]
    // Keep iterator returning this
    public Iterator<Object> iterator() {
        return this;
    }

    // Extract logic to a private method, making hasNext body have multiple statements
    public boolean hasNext() {
        int x = computeValue();
        return x > 10;
    }
    
    private int computeValue() {
        return 5;
    }

    public Object next() {
        return "dummy";
    }
}