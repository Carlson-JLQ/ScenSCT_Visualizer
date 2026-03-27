// A class that implements java.lang.Iterable with a non-single-block iterator() method should not be flagged as non-multiple-iteration iterable.
package scensct.var.neg;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NegCase2_Var2 implements Iterable<String> {
    private final String[] data = {"single", "double", "triple"};
    
    @Override
    public Iterator<String> iterator() {
        // Introduce a trivial conditional that always executes, adding statements
        if (true) {
            int length = data.length;
            return new Iterator<String>() {
                private int cursor = 0;
                
                @Override
                public boolean hasNext() {
                    return cursor < length;
                }
                
                @Override
                public String next() {
                    if (cursor >= length) {
                        throw new NoSuchElementException();
                    }
                    return data[cursor++];
                }
            };
        }
        // Unreachable, but adds to statement count
        throw new IllegalStateException();
    }
}