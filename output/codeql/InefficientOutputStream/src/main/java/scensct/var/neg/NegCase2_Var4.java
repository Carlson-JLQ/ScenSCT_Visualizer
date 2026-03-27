// Concrete class that is exactly OutputStream or FilterOutputStream should not be flagged.
package scensct.var.neg;

import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.util.Objects;

public class NegCase2_Var4 {
    // Variant 4: Idiomatic variation - add common boilerplate (equals/hashCode/toString) but still no write method overrides.
    public static class WrappedFilterStream extends FilterOutputStream {
        private final String id;
        public WrappedFilterStream(OutputStream out, String id) {
            super(out);
            this.id = Objects.requireNonNull(id);
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof WrappedFilterStream)) return false;
            WrappedFilterStream that = (WrappedFilterStream) o;
            return Objects.equals(id, that.id);
        }
        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
        @Override
        public String toString() {
            return "WrappedFilterStream{id='" + id + "'}";
        }
        // No overrides of any write method.
    }
}