// A class that implements java.lang.Iterable with a non-single-block iterator() method should not be flagged as non-multiple-iteration iterable.
package scensct.var.neg;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NegCase2_Var3 implements Iterable<String> {
    private final String[] data = {"alpha", "beta", "gamma"};
    
    // Helper method to create iterator, keeping iterator() multi-statement
    private Iterator<String> createIterator() {
        return new Iterator<String>() {
            private int idx = 0;
            
            @Override
            public boolean hasNext() {
                return idx < data.length;
            }
            
            @Override
            public String next() {
                if (!hasNext()) throw new NoSuchElementException();
                return data[idx++];
            }
        };
    }
    
    @Override
    public Iterator<String> iterator() {
        // Multiple statements: call helper after a declaration
        String[] localRef = data;
        return createIterator();
    }
}