// A class implements Iterable and returns a final field of type Iterator directly, which should be flagged as not supporting multiple iterations.
package scensct.var.pos;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PosCase1_Var5 implements Iterable<String> {
    private final Iterator<String> singleIterator = new Iterator<String>() {
        private int calls = 0;
        @Override
        public boolean hasNext() {
            return calls == 0;
        }
        @Override
        public String next() {
            if (calls != 0) throw new NoSuchElementException();
            calls++;
            return "value";
        }
    };

    @Override
    public Iterator<String> iterator() {
        return (singleIterator.hasNext()) ? singleIterator : singleIterator;
    }
}