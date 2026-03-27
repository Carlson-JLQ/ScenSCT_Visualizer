// A class without the @ThreadSafe annotation contains a non-final, non-private, non-volatile field should not be flagged as thread-safe concurrency issue.
package scensct.var.neg;

public class NegCase1_Var4 {
    // Field declared with an interface type (Runnable) but still non-final, non-private, non-volatile
    Runnable task;

    // Setter method - no synchronization
    public void setTask(Runnable t) {
        this.task = t;
    }

    // Method that executes the task if present
    public void execute() {
        if (task != null) {
            task.run();
        }
    }

    // Override toString using the field
    @Override
    public String toString() {
        return "NegCase1_Var4 with task: " + task;
    }
}