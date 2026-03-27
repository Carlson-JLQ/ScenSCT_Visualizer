// A class that implements java.lang.Iterable with a non-single-block iterator() method should not be flagged as non-multiple-iteration iterable.
package scensct.var.neg;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NegCase2_Var5 implements Iterable<String> {
    private final String[] data = {"foo", "bar", "baz"};
    
    @Override
    public Iterator<String> iterator() {
        // Use a separate class for iterator instead of anonymous
        class LocalIterator implements Iterator<String> {
            private int current = 0;
            
            @Override
            public boolean hasNext() {
                return current < data.length;
            }
            
            @Override
            public String next() {
                if (current >= data.length) {
                    throw new NoSuchElementException();
                }
                return data[current++];
            }
        }
        // Multiple statements: prepare and return
        LocalIterator iter = new LocalIterator();
        return iter;
    }
}