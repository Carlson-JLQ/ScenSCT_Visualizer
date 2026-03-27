// A class that implements java.lang.Iterable with a non-single-block iterator() method should not be flagged as non-multiple-iteration iterable.
package scensct.core.neg;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NegCase2 implements Iterable<String> {
    private final String[] data = {"a", "b", "c"};
    
    // iterator() method contains multiple statements (not a single block/return),
    // so the checker's detection logic for single-instance returns should not trigger.
    @Override
    public Iterator<String> iterator() {
        // Multiple statements: initialization and return.
        int count = data.length;
        return new Iterator<String>() {
            private int index = 0;
            
            @Override
            public boolean hasNext() {
                return index < count;
            }
            
            @Override
            public String next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return data[index++];
            }
        };
    }
}