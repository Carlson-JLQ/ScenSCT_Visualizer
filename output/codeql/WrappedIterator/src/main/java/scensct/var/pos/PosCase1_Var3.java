// A class implements Iterable and returns a final field of type Iterator directly, which should be flagged as not supporting multiple iterations.
package scensct.var.pos;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PosCase1_Var3 implements Iterable<String> { // [REPORTED LINE]
    private final Iterator<String> singleIterator = createSingletonIterator();

    private static Iterator<String> createSingletonIterator() {
        return new Iterator<String>() {
            private int count = 0;
            @Override
            public boolean hasNext() {
                return count < 1;
            }
            @Override
            public String next() {
                if (count >= 1) throw new NoSuchElementException();
                count++;
                return "single";
            }
        };
    }

    @Override
    public Iterator<String> iterator() {
        return singleIterator;
    }
}