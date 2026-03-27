// A class implements Iterable, declares an iterator() method that returns "this", and any declared method named "hasNext" has a method body that does not contain exactly one statement should be flagged as lacking a guard against multiple concurrent iterations.
package scensct.var.pos;

import java.util.Iterator;

public class PosCase3_Var4 implements Iterable<Object>, Iterator<Object> { // [REPORTED LINE]
    private int count = 0;
    
    // Still returns this
    public Iterator<Object> iterator() {
        return this;
    }

    // hasNext with loop and multiple statements
    public boolean hasNext() {
        for (int i = 0; i < 1; i++) {
            count++;
        }
        return count < 5;
    }

    public Object next() {
        count++;
        return null;
    }
}