// Throwable.getMessage() result not flowing to the given EXPR should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;

public class NegCase5_Var4 {
    public void handleError(Throwable t, PrintWriter out) {
        // Variant 4: Message wrapped in a container object, still printed to stderr
        MessageHolder holder = new MessageHolder(t.getMessage());
        System.err.println(holder.get());
    }

    private static class MessageHolder {
        private final String content;
        MessageHolder(String c) { this.content = c; }
        String get() { return content; }
    }
}