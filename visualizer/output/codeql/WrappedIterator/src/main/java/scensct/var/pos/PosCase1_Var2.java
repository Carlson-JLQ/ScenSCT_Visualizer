// A class implements Iterable and returns a final field of type Iterator directly, which should be flagged as not supporting multiple iterations.
package scensct.var.pos;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PosCase1_Var2 implements Iterable<String> {
    private final Iterator<String> singleIterator;

    public PosCase1_Var2() {
        singleIterator = new Iterator<String>() {
            private boolean yielded = false;
            @Override
            public boolean hasNext() {
                return !yielded;
            }
            @Override
            public String next() {
                if (!hasNext()) throw new NoSuchElementException();
                yielded = true;
                return "item";
            }
        };
    }

    @Override
    public Iterator<String> iterator() {
        Iterator<String> it = singleIterator;
        return it;
    }
}