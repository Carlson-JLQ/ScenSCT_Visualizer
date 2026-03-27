// A class that implements java.lang.Iterable with a non-single-block iterator() method should not be flagged as non-multiple-iteration iterable.
package scensct.var.neg;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NegCase2_Var1 implements Iterable<String> {
    private final String[] items = {"x", "y", "z"};
    
    @Override
    public Iterator<String> iterator() {
        // Multiple statements preserved: compute size, then return new iterator
        final int size = items.length;
        Iterator<String> it = new Iterator<String>() {
            private int pos = 0;
            
            @Override
            public boolean hasNext() {
                return pos < size;
            }
            
            @Override
            public String next() {
                if (pos >= size) {
                    throw new NoSuchElementException();
                }
                return items[pos++];
            }
        };
        return it;
    }
}