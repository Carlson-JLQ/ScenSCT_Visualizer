// A class implements Iterable and returns a final field of type Iterator directly, which should be flagged as not supporting multiple iterations.
package scensct.core.pos;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PosCase1 implements Iterable<String> { // [REPORTED LINE]
    private final Iterator<String> singleIterator = new Iterator<String>() {
        private int count = 0;
        @Override
        public boolean hasNext() {
            return count < 1;
        }
        @Override
        public String next() {
            if (!hasNext()) throw new NoSuchElementException();
            count++;
            return "item";
        }
    };

    @Override
    public Iterator<String> iterator() {
        return singleIterator; // Returns the same final iterator instance each time.
    }
}