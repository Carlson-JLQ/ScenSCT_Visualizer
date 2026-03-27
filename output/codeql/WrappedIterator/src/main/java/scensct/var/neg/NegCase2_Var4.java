// A class that implements java.lang.Iterable with a non-single-block iterator() method should not be flagged as non-multiple-iteration iterable.
package scensct.var.neg;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NegCase2_Var4 implements Iterable<String> {
    private final String[] data = {"1", "2", "3"};
    
    @Override
    public Iterator<String> iterator() {
        // Split single logical line into multiple statements
        int n;
        n = data.length;
        // Additional no-op statement
        assert n >= 0 : "size should be non-negative";
        return new Iterator<String>() {
            private int i = 0;
            
            @Override
            public boolean hasNext() {
                return i < n;
            }
            
            @Override
            public String next() {
                if (i >= n) throw new NoSuchElementException();
                return data[i++];
            }
        };
    }
}