// A class implements Iterable and returns a final field of type Iterator directly, which should be flagged as not supporting multiple iterations.
package scensct.var.pos;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PosCase1_Var4 implements Iterable<String> { // [REPORTED LINE]
    private final Iterator<String> singleIterator;

    {
        singleIterator = new Iterator<String>() {
            private boolean done = false;
            @Override
            public boolean hasNext() {
                return !done;
            }
            @Override
            public String next() {
                if (done) throw new NoSuchElementException();
                done = true;
                return "data";
            }
        };
    }

    @Override
    public Iterator<String> iterator() {
        return this.singleIterator;
    }
}