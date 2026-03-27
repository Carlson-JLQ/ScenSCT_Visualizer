// A class implements Iterable and returns a final field of type Iterator directly, which should be flagged as not supporting multiple iterations.
package scensct.var.pos;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PosCase1_Var1 implements Iterable<String> { // [REPORTED LINE]
    private final Iterator<String> cachedIterator = new Iterator<String>() {
        private int remaining = 1;
        @Override
        public boolean hasNext() {
            return remaining > 0;
        }
        @Override
        public String next() {
            if (!hasNext()) throw new NoSuchElementException();
            remaining--;
            return "element";
        }
    };

    @Override
    public Iterator<String> iterator() {
        return cachedIterator;
    }
}